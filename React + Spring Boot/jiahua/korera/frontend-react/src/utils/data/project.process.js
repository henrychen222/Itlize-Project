export const parseResources2Tree = resources => {
  const tree = {};

  let result = resources.sort((a, b) => (a.cost_code < b.cost_code ? -1 : 1));
  result = result.map(resource => ({
    ...resource,
    split$result: resource.cost_code.split(' ')
  }));

  result.forEach(resource => {
    resource.selected = false;
    let pointer = tree;

    for (let [index, split] of resource.split$result.entries()) {
      if (split in pointer) {
        pointer[split].$count++;
        if (index + 1 === resource.split$result.length) {
          pointer[split].$kids.push(resource);
        } else {
          pointer = pointer[split];
        }
      } else {
        pointer[split] = {
          $parent: resource,
          $kids: [],
          $showKids: false,
          $indent: index,
          $count: 0
        };
        break;
      }
    }
  });
  return tree;
};

export const parseProjects2Tree = projects => {
  const tree = {};

  let result = projects.sort((a, b) => (a.cost_code < b.cost_code ? -1 : 1));
  result = result.map(project => ({
    ...project,
    selected: false,
    resource: {
      ...project.resource,
      split$result: project.cost_code.split(' ')
    }
  }));

  result.forEach(project => {
    let pointer = tree;

    for (let [index, split] of project.resource.split$result.entries()) {
      if (split in pointer) {
        pointer[split].$count++;
        if (index + 1 === project.resource.split$result.length) {
          pointer[split].$kids.push(project);
        } else {
          pointer = pointer[split];
        }
      } else {
        pointer[split] = {
          $parent: project,
          $kids: [],
          $showKids: false,
          $indent: index,
          $count: 0
        };
        break;
      }
    }
  });
  return tree;
};

export const resource2project = resource => {
  const { name, cost_code } = resource;
  return { name, cost_code, resource, selected: false };
};

export const insertProject2treeInPlace = (tree, project) => {
  // check if this resource already existed
  let pointer = tree;
  for (let split of project.resource.split$result) {
    if (split in pointer) {
      if (
        pointer[split].$parent.resource.id === project.resource.id ||
        pointer[split].$kids.some(
          kid => kid.resource.id === project.resource.id
        )
      ) {
        return;
      }
      pointer = pointer[split];
    } else {
      break;
    }
  }

  // insert for sure
  for (let [index, split] of project.resource.split$result.entries()) {
    if (split in tree) {
      tree[split].$count++;
      if (index + 1 === project.resource.split$result.length) {
        tree[split].$kids.push(project);
      } else {
        tree = tree[split];
      }
    } else {
      tree[split] = {
        $parent: project,
        $kids: [],
        $showKids: false,
        $indent: index,
        $count: 0
      };
      return;
    }
  }
};

export const separateProjectTree = tree => {
  let [keptProjects, deletedProjects] = [[], []];

  Object.entries(tree).forEach(([name, value]) => {
    if (name.startsWith('$')) {
      if (name === '$parent') {
        if (value.selected) {
          if (value.id) {
            deletedProjects.push(value);
          }
        } else {
          keptProjects.push(value);
        }
      } else if (name === '$kids') {
        value.forEach(kid => {
          if (kid.selected) {
            if (kid.id) {
              deletedProjects.push(kid);
            }
          } else {
            keptProjects.push(kid);
          }
        });
      }
    } else {
      const [keptKids, deletedKids] = separateProjectTree(value);
      keptProjects = [...keptProjects, ...keptKids];
      deletedProjects = [...deletedProjects, ...deletedKids];
    }
  });

  return [keptProjects, deletedProjects];
};

export const getNeededUpdatedProjects = (tree, projectId) => {
  let result = [];

  Object.entries(tree).forEach(([name, value]) => {
    if (name.startsWith('$')) {
      if (name === '$parent') {
        if (!value.id) {
          value.projectId = projectId;

          delete value.selected;
          delete value.resource.split$result;
          delete value.resource.selected;

          result.push(value);
        }
      } else if (name === '$kids') {
        value.forEach(kid => {
          if (!kid.id) {
            kid.projectId = projectId;

            delete kid.selected;
            delete kid.resource.split$result;
            delete kid.resource.selected;

            result.push(kid);
          }
        });
      }
    } else {
      const subResult = getNeededUpdatedProjects(value, projectId);
      result = [...result, ...subResult];
    }
  });

  return result;
};
