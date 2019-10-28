import React, { useEffect, useState } from 'react';

import styles from './MainTable.module.sass';
import {
  getFormulaByProjectId,
  loadProjectsById,
  batchUpdateProjects
} from '../../utils/api/api';
import {
  formula2tableHeadNames,
  parseData2tree,
  parseTree2DataList
} from '../../utils/data/formula';
import { formatHeader } from '../../utils/data/resource.process';
import ArrowDropDown from '../../Icons/ArrowDropDown';
import ArrowRight from '../../Icons/ArrowRight';

export function MainTable({ chosenProjectId, submitted, setSubmitted }) {
  const [tableHeadNames, setTableHeadNames] = useState([]);
  const [dataTree, setDataTree] = useState({});
  const [survey, setSurvey] = useState({});

  useEffect(() => {
    const load = async () => {
      const result = await getFormulaByProjectId(chosenProjectId);
      const projects = await loadProjectsById(chosenProjectId);

      setSurvey(result.survey);
      setTableHeadNames(formula2tableHeadNames(result));
      setDataTree(parseData2tree(projects));
    };

    load();
  }, [chosenProjectId]);

  useEffect(() => {
    const handleSubmit = async () => {
      if (submitted) {
        batchUpdateProjects(parseTree2DataList(dataTree));
        const projects = await loadProjectsById(chosenProjectId);

        setDataTree(parseData2tree(projects));
        setSubmitted(false);
      }
    };

    handleSubmit();
  }, [dataTree, setSubmitted, submitted, chosenProjectId]);

  const handleParentToggle = (parentTree, setTree) => {
    setTree(tree => {
      const newTree = { ...tree };
      let pointer = newTree;
      const { split$result } = parentTree.$parent;
      const { id } = parentTree.$parent.resource;

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

  const handleChange = (event, project, setter) => {
    event.persist();
    const { name, value } = event.target;

    setter(values => {
      const newValues = { ...values };
      let pointer = newValues;
      for (let split of project.split$result) {
        pointer = pointer[split];

        if (pointer.$parent.id === project.id) {
          if (name.includes('$')) {
            pointer.$parent.survey_fields[name] = value;
            break;
          } else {
            pointer.$parent[name] = value;
            break;
          }
        } else {
          const newKids = pointer.$kids.map(kid => {
            if (kid.id === project.id) {
              if (name.includes('$')) {
                kid.survey_fields[name] = value;
              } else {
                kid[name] = value;
              }
              return kid;
            } else {
              return kid;
            }
          });
          pointer.$kids = newKids;
        }
      }

      return newValues;
    });
  };

  const getFormulaOutcome = (name, project) => {
    let formula = survey[name];

    Object.entries(project.survey_fields).forEach(([field, value]) => {
      field = field.substring(0, field.indexOf('$'));
      const regExp = new RegExp(field, 'g');
      formula = formula.replace(regExp, value);
    });

    try {
      const result = eval(formula);
      return Number.isNaN(result) ? '' : result;
    } catch (error) {
      return;
    }
  };

  const getDisplayedCell = (name, project, indent, setter) => {
    if (name.includes('$')) {
      const current = project.$parent ? project.$parent : project;

      if (name.endsWith('$formula')) {
        return (
          <td key={`${name} ${current.id}`}>
            {getFormulaOutcome(name, current)}
          </td>
        );
      } else {
        return (
          <td key={`${name} ${current.id}`}>
            <input
              name={name}
              value={current.survey_fields[name] || ''}
              type={name.substring(name.indexOf('$') + 1)}
              onChange={event => handleChange(event, current, setter)}
            />
          </td>
        );
      }
    }

    if (project.$parent) {
      if (name === 'name') {
        return (
          <td
            key={`${name} ${project.$parent.id}`}
            style={{
              paddingLeft: project.$count ? indent * 10 : indent * 10 + 10
            }}
          >
            {!project.$count ? null : project.$showKids ? (
              <ArrowDropDown
                onClick={() => handleParentToggle(project, setter)}
              />
            ) : (
              <ArrowRight onClick={() => handleParentToggle(project, setter)} />
            )}
            <input
              type="text"
              value={project.$parent.name}
              onChange={event => handleChange(event, project.$parent, setter)}
              name={name}
            />
          </td>
        );
      } else if (name === 'cost_code') {
        return (
          <td key={`${name} ${project.$parent.id}`}>
            <input
              type="text"
              value={project.$parent.cost_code}
              onChange={event => handleChange(event, project.$parent, setter)}
              name={name}
            />
          </td>
        );
      }
    } else {
      if (name === 'name') {
        return (
          <td
            style={{
              paddingLeft: indent * 10 + 20
            }}
            key={`${name} ${project.id}`}
          >
            <input
              type="text"
              value={project.name}
              onChange={event => handleChange(event, project, setter)}
              name={name}
            />
          </td>
        );
      } else if (name === 'cost_code') {
        return (
          <td key={`${name} ${project.id}`}>
            <input
              type="text"
              value={project.cost_code}
              onChange={event => handleChange(event, project, setter)}
              name={name}
            />
          </td>
        );
      }
    }
  };

  const renderTree = (projectsTree, tableHeadNames, setTree) => {
    if (!projectsTree.$parent) return;

    return (
      <React.Fragment key={projectsTree.$parent.id}>
        <tr>
          {tableHeadNames.map(name =>
            getDisplayedCell(name, projectsTree, projectsTree.$indent, setTree)
          )}
        </tr>
        {projectsTree.$showKids &&
          Object.values(projectsTree).map(t =>
            renderTree(t, tableHeadNames, setTree)
          )}
        {projectsTree.$showKids &&
          projectsTree.$kids.map(kid => (
            <tr key={kid.id}>
              {tableHeadNames.map(name =>
                getDisplayedCell(name, kid, projectsTree.$indent, setTree)
              )}
            </tr>
          ))}
      </React.Fragment>
    );
  };

  return (
    <main className={styles.survey}>
      <header>QUANTITY SURVEY</header>

      <div>
        <table>
          <thead>
            <tr>
              {tableHeadNames.map(name => (
                <th key={name}>{formatHeader(name)}</th>
              ))}
            </tr>
          </thead>
          <tbody>
            {Object.values(dataTree).map(d =>
              renderTree(d, tableHeadNames, setDataTree)
            )}
          </tbody>
        </table>
      </div>
    </main>
  );
}
