import React, { useEffect, useState } from 'react';

import styles from './Table.module.sass';
import {
  loadProjectsById,
  batchDeleteProjects,
  batchUpdateProjects
} from '../../utils/api/api';
import {
  parseProjects2Tree,
  resource2project,
  insertProject2treeInPlace,
  separateProjectTree,
  getNeededUpdatedProjects
} from '../../utils/data/project.process.js';
import ArrowDropDown from '../../Icons/ArrowDropDown';
import ArrowRight from '../../Icons/ArrowRight';
import SelectState from '../../Icons/SelectState';
import CheckboxNoSelected from '../../Icons/CheckboxNoSelected';

export function ProjectTable({
  chosenProjectId,
  exportCurrent,
  setExportCurrent,
  trash,
  setTrash,
  submitted,
  setSubmitted
}) {
  const [tree, setTree] = useState({});
  const [deletedProjects, setDeletedProjects] = useState([]);

  const load = async chosenProjectId => {
    const projects = await loadProjectsById(chosenProjectId);
    const result = parseProjects2Tree(projects);
    setTree(result);
  };

  useEffect(() => {
    load(chosenProjectId);
  }, [chosenProjectId]);

  useEffect(() => {
    if (
      exportCurrent.exportedResources &&
      exportCurrent.exportedResources.length
    ) {
      const projects = exportCurrent.exportedResources.map(resource2project);

      const newTree = { ...tree };
      projects.forEach(project => insertProject2treeInPlace(newTree, project));
      setTree(newTree);

      setExportCurrent({ start: false });
    } else {
    }
  }, [exportCurrent, setExportCurrent, tree]);

  useEffect(() => {
    if (trash) {
      const [keptProjects, newDeletedProjects] = separateProjectTree(tree);

      setDeletedProjects(value => [...value, ...newDeletedProjects]);
      setTree(parseProjects2Tree(keptProjects));

      setTrash(false);
    }
  }, [setTrash, trash, tree]);

  useEffect(() => {
    const handleSubmit = async () => {
      if (deletedProjects.length) {
        await batchDeleteProjects(deletedProjects);
      }

      const updatedProjects = getNeededUpdatedProjects(tree, chosenProjectId);
      if (updatedProjects.length) {
        await batchUpdateProjects(updatedProjects);
      }

      load(chosenProjectId);
    };

    if (submitted) {
      handleSubmit();
      setSubmitted(false);
    }
  }, [chosenProjectId, deletedProjects, setSubmitted, submitted, tree]);

  const handleParentToggle = (parentTree, setTree) => {
    setTree(tree => {
      const newTree = { ...tree };
      let pointer = newTree;
      const { split$result, id } = parentTree.$parent.resource;

      for (const split of split$result) {
        pointer = pointer[split];
        if (pointer.$parent.resource.id === id) {
          pointer.$showKids = !pointer.$showKids;
          break;
        }
      }

      return newTree;
    });
  };

  const toggleSelect = (project, setTree) => {
    setTree(tree => {
      const newTree = { ...tree };
      let pointer = newTree;
      const { split$result, id } = project.resource;

      for (const split of split$result) {
        pointer = pointer[split];
        if (pointer.$parent.resource.id === id) {
          pointer.$parent.selected = !pointer.$parent.selected;
          break;
        }
      }

      if (pointer.$parent.resource.id !== id) {
        const kids = pointer.$kids.map(kid => {
          if (kid.resource.id === id) {
            kid.selected = !kid.selected;
          }
          return kid;
        });
        pointer.$kids = kids;
      }

      return newTree;
    });
  };

  const renderTree = (projectsTree, setTree) => {
    if (!projectsTree.$parent) return;

    return (
      <React.Fragment key={projectsTree.$parent.resource.id}>
        <tr>
          <td
            style={{
              paddingLeft: projectsTree.$count
                ? projectsTree.$indent * 10
                : projectsTree.$indent * 10 + 10
            }}
          >
            {!projectsTree.$count ? null : projectsTree.$showKids ? (
              <ArrowDropDown
                onClick={() => handleParentToggle(projectsTree, setTree)}
              />
            ) : (
              <ArrowRight
                onClick={() => handleParentToggle(projectsTree, setTree)}
              />
            )}
            {projectsTree.$parent.selected ? (
              <SelectState
                onClick={() => toggleSelect(projectsTree.$parent, setTree)}
              />
            ) : (
              <CheckboxNoSelected
                onClick={() => toggleSelect(projectsTree.$parent, setTree)}
              />
            )}
            <span>{' ' + projectsTree.$parent.name.trim()}</span>
          </td>
          <td>{projectsTree.$parent.cost_code}</td>
        </tr>
        {projectsTree.$showKids &&
          Object.values(projectsTree).map(t => renderTree(t, setTree))}
        {projectsTree.$showKids &&
          projectsTree.$kids.map(kid => (
            <tr key={kid.resource.id}>
              <td
                style={{
                  paddingLeft: projectsTree.$indent * 10 + 20
                }}
              >
                {kid.selected ? (
                  <SelectState onClick={() => toggleSelect(kid, setTree)} />
                ) : (
                  <CheckboxNoSelected
                    onClick={() => toggleSelect(kid, setTree)}
                  />
                )}
                {kid.name}
              </td>
              <td> {kid.cost_code} </td>
            </tr>
          ))}
      </React.Fragment>
    );
  };

  return (
    <div className={styles.container}>
      <table>
        <thead>
          <tr>
            <th>PROJECT NAME</th>
            <th>PROJECT CODE</th>
          </tr>
        </thead>
        <tbody>{Object.values(tree).map(t => renderTree(t, setTree))}</tbody>
      </table>
    </div>
  );
}
