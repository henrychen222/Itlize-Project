import { loadResources, updateResource, updateResources } from '../api/api';

export const getExtraNames = resources => {
  const result = new Set();
  resources.forEach(({ data }) => {
    Object.keys(data).forEach(name => result.add(name));
  });
  return result;
};

export const formatHeader = name =>
  name.includes('$') ? name.substring(0, name.indexOf('$')) : name;

export const processResources = resources => {
  let result = resources.sort((a, b) => (a.cost_code < b.cost_code ? -1 : 1));
  result = result.map(resource => ({
    ...resource,
    split$result: resource.cost_code.split(' ')
  }));

  const hierarchy = {};
  result.forEach(({ id, split$result }) => {
    let pointer = hierarchy;
    for (let split of split$result) {
      let padding$level = 0;
      if (pointer.id) {
        if (pointer.id === id) {
          padding$level = pointer.padding$level;
        } else {
          padding$level = pointer.padding$level + 1;
        }
      }

      if (split in pointer) {
        pointer[split].count += 1;
      } else {
        pointer[split] = {
          count: 1,
          id,
          show: false,
          padding$level
        };
      }
      pointer = pointer[split];
    }
  });

  result = result.map(resource => {
    let pointer = hierarchy;
    for (let split of resource.split$result) {
      let current = pointer[split];

      if (resource.id === current.id) {
        if (current.count > 1) {
          resource.is$parent = true;
        }

        resource.padding$level = current.padding$level;
        if ('show' in pointer) {
          resource.show$status = pointer.show;
        } else {
          resource.show$status = true;
          break;
        }
      } else {
        resource.show$status = current.show;
        resource.padding$level = current.padding$level + 1;
      }

      pointer = pointer[split];
    }
    return resource;
  });

  return [result, hierarchy];
};

export const actionTypes = {
  init_herarchy: 'init_herarchy',
  init_resources: 'init_resources',
  toggle: 'toggle'
};

export const reducer = (state, action) => {
  switch (action.type) {
    case actionTypes.init_herarchy:
      return { ...state, hierarchy: action.hierarchy };
    case actionTypes.init_resources:
      return { ...state, resources: action.resources };
    case actionTypes.toggle:
      let hierarchy = { ...state.hierarchy };
      let pointer = hierarchy;
      action.resource.split$result.forEach(key => {
        pointer = pointer[key];
        if (pointer.id === action.resource.id) {
          pointer.show = !pointer.show;
        }
      });

      const resources = state.resources.map(resource => {
        let pointer = hierarchy;

        for (let key of resource.split$result) {
          const current = pointer[key];

          if (current.id === resource.id) {
            if ('show' in pointer) {
              resource.show$status = pointer.show;
              break;
            } else {
              resource.show$status = true;
              break;
            }
          } else {
            resource.show$status = current.show;
            if (!current.show) {
              break;
            }
          }
          pointer = pointer[key];
        }

        return resource;
      });

      return { ...state, hierarchy, resources };
    default:
      return state;
  }
};

export const initLoad = async (setTableHead, dispatch) => {
  const resources = await loadResources();
  const headNames = getExtraNames(resources);
  const [body, hierarchy] = processResources(resources);

  setTableHead(headNames);
  dispatch({ type: actionTypes.init_herarchy, hierarchy });
  dispatch({ type: actionTypes.init_resources, resources: body });
};

export const getSign = ({ id, split$result }, state) => {
  let pointer = state.hierarchy;
  if (!pointer || !id || !split$result) return '!';

  for (let split of split$result) {
    pointer = pointer[split];
    if (pointer.id === id) {
      if (pointer.show) {
        return '- ';
      } else {
        return '+ ';
      }
    }
  }

  return '~';
};

export const shouldDisplay = (resource, search, none, parent) => {
  if (search) {
    search = search.toUpperCase();
    if (
      resource.name.toUpperCase().includes(search) ||
      resource.cost_code.toUpperCase().includes(search) ||
      Object.values(resource.data).some(value =>
        value.toUpperCase().includes(search)
      )
    ) {
      return '';
    }

    return none;
  }

  if (!resource.show$status) {
    return none;
  }

  return resource.is$parent ? `${parent}` : '';
};

export const handleAddRow = async (
  addRowRef,
  setTableHead,
  dispatch,
  setAddRow
) => {
  const newResource = { name: '', cost_code: '', data: {} };
  const kids = [...addRowRef.current.children];
  for (let kid of kids) {
    const { name, value } = kid.lastChild.lastChild;
    if (name in newResource) {
      if (!value) {
        return alert(`${name} is required!`);
      }
      newResource[name] = value;
    } else {
      if (value) {
        newResource.data[name] = value;
      }
    }
  }
  await updateResource(newResource);
  await initLoad(setTableHead, dispatch);
  setAddRow(false);
};

export const handleAddColumnInput = (event, setAddColumn) => {
  const { name, value } = event.target;
  if (name === 'name') {
    setAddColumn(values => ({ ...values, columnName: value }));
  } else {
    setAddColumn(({ on, columnName, pairs }) => ({
      on,
      columnName,
      pairs: { ...pairs, [name]: value }
    }));
  }
};

export const handleAddColumn = async (
  addColumn,
  tableHead,
  state,
  setTableHead,
  dispatch,
  setAddColumn
) => {
  const { columnName, pairs } = addColumn;
  if (!columnName) {
    return alert('new column name cannot be empty');
  }

  const names = [...tableHead].map(formatHeader);
  if (names.includes(columnName)) {
    return alert(`column name ${columnName} already existed!`);
  }

  const entries = Object.entries(pairs).filter(([, value]) => value);
  if (!entries.length) {
    return;
  }

  const { resources } = state;
  const updatedResources = [];
  for (let [index, value] of entries) {
    const newResource = resources[index];
    newResource.data[`${columnName}$text`] = value;
    updatedResources.push(newResource);
  }
  await updateResources(updatedResources);
  await initLoad(setTableHead, dispatch);
  setAddColumn({ on: false });
};

const resourceProcess = {
  getExtraNames,
  formatHeader,
  processResources,
  actionTypes,
  reducer,
  initLoad,
  getSign,
  shouldDisplay,
  handleAddRow,
  handleAddColumnInput,
  handleAddColumn
};

export default resourceProcess;
