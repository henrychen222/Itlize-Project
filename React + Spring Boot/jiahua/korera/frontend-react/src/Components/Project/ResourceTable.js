import React, { useEffect, useState } from 'react';

import styles from './Table.module.sass';
import api from '../../utils/api/api';
import { parseResources2Tree } from '../../utils/data/project.process.js';
import ArrowDropDown from '../../Icons/ArrowDropDown';
import ArrowRight from '../../Icons/ArrowRight';
import SelectState from '../../Icons/SelectState';
import CheckboxNoSelected from '../../Icons/CheckboxNoSelected';

export function ResourceTable({
  selectResources,
  setSelectResources,
  exportCurrent,
  setExportCurrent
}) {
  const [tree, setTree] = useState({});

  useEffect(() => {
    const load = async () => {
      const resources = await api.loadResources();
      const resourcesTree = parseResources2Tree(resources);
      setTree(resourcesTree);
    };

    load();
  }, []);

  useEffect(() => {
    const getSelectedResources = tree => {
      let resources = [];
      Object.entries(tree).forEach(([name, value]) => {
        if (name === '$parent') {
          if (value.selected) {
            resources.push(value);
          }
        } else if (name === '$kids') {
          resources = [...resources, ...value.filter(kid => kid.selected)];
        } else {
          resources = [...resources, ...getSelectedResources(value)];
        }
      });

      return resources;
    };

    if (exportCurrent.start) {
      const exportedResources = getSelectedResources(tree);

      setExportCurrent({
        start: false,
        exportedResources
      });
    }
  }, [exportCurrent, setExportCurrent, tree]);

  useEffect(() => {
    const flipTreeSelectionsInPlace = (tree, state = true) => {
      if (tree.$parent) {
        tree.$parent.selected = state;
      }

      if (tree.$kids) {
        tree.$kids = tree.$kids.map(kid => {
          kid.selected = state;
          return kid;
        });
      }

      for (const item in tree) {
        if (!item.startsWith('$')) {
          flipTreeSelectionsInPlace(tree[item], state);
        }
      }
    };

    if (selectResources) {
      const state = selectResources === 'all' ? true : false;
      setTree(tree => {
        const newTree = { ...tree };
        flipTreeSelectionsInPlace(newTree, state);
        return tree;
      });
      setSelectResources('');
    }
  }, [selectResources, setSelectResources, tree]);

  const handleParentToggle = (parentTree, setTree) => {
    setTree(tree => {
      const newTree = { ...tree };
      let pointer = newTree;
      const { split$result, id } = parentTree.$parent;

      for (const split of split$result) {
        pointer = pointer[split];
        if (pointer.$parent.id === id) {
          pointer.$showKids = !pointer.$showKids;
          break;
        }
      }

      return newTree;
    });
  };

  const toggleSelect = (resource, setTree) => {
    setTree(tree => {
      const newTree = { ...tree };
      let pointer = newTree;
      const { split$result, id } = resource;

      for (const split of split$result) {
        pointer = pointer[split];
        if (pointer.$parent.id === id) {
          pointer.$parent.selected = !pointer.$parent.selected;
          break;
        }
      }

      if (pointer.$parent.id !== id) {
        const kids = pointer.$kids.map(kid => {
          if (kid.id === id) {
            kid.selected = !kid.selected;
          }
          return kid;
        });
        pointer.$kids = kids;
      }

      return newTree;
    });
  };

  const renderTree = (resourcesTree, setTree) => {
    if (!resourcesTree.$parent) return;

    return (
      <React.Fragment key={resourcesTree.$parent.id}>
        <tr>
          <td
            style={{
              paddingLeft: resourcesTree.$count
                ? resourcesTree.$indent * 10
                : resourcesTree.$indent * 10 + 10
            }}
          >
            {!resourcesTree.$count ? null : resourcesTree.$showKids ? (
              <ArrowDropDown
                onClick={() => handleParentToggle(resourcesTree, setTree)}
              />
            ) : (
              <ArrowRight
                onClick={() => handleParentToggle(resourcesTree, setTree)}
              />
            )}
            {resourcesTree.$parent.selected ? (
              <SelectState
                onClick={() => toggleSelect(resourcesTree.$parent, setTree)}
              />
            ) : (
              <CheckboxNoSelected
                onClick={() => toggleSelect(resourcesTree.$parent, setTree)}
              />
            )}
            <span>{' ' + resourcesTree.$parent.name.trim()}</span>
          </td>
          <td>{resourcesTree.$parent.cost_code}</td>
        </tr>
        {resourcesTree.$showKids &&
          Object.values(resourcesTree).map(t => renderTree(t, setTree))}
        {resourcesTree.$showKids &&
          resourcesTree.$kids.map(kid => (
            <tr key={kid.id}>
              <td
                style={{
                  paddingLeft: resourcesTree.$indent * 10 + 20
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
