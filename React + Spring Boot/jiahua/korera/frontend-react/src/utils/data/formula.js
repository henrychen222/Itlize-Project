export const surveyEntity2object = survey => {
  if (!survey) return [];

  const result = [];

  Object.entries(survey).forEach(([name, formula]) => {
    const [field, type] = name.split('$');
    result.push({
      field,
      type,
      formula
    });
  });

  return result;
};

export const surveyObject2Entity = survey => {
  const result = {};

  Object.values(survey).forEach(
    ({ field, type, formula }) =>
      (result[`${field}$${type}`] = type === 'formula' ? formula : '')
  );

  return result;
};

export const formula2tableHeadNames = formula => {
  const result = [];

  Object.entries(formula.scope).forEach(([name, value]) => {
    if (value) {
      result.push(name);
    }
  });
  Object.keys(formula.survey).forEach(name => result.push(name));

  return result;
};

export const parseData2tree = data => {
  const tree = {};

  let result = data.sort((a, b) => (a.cost_code < b.cost_code ? -1 : 1));
  result = result.map(project => ({
    ...project,
    split$result: project.cost_code.split(/\s/)
  }));

  result.forEach(project => {
    let pointer = tree;

    for (let [index, split] of project.split$result.entries()) {
      if (split in pointer) {
        pointer[split].$count++;
        if (index + 1 === project.split$result.length) {
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

export const parseTree2DataList = tree => {
  let result = [];

  Object.entries(tree).forEach(([name, value]) => {
    if (name.startsWith('$')) {
      if (name === '$parent') {
        result.push(value);
      } else if (name === '$kids') {
        value.forEach(kid => {
          result.push(kid);
        });
      }
    } else {
      const subResult = parseTree2DataList(value);
      result = [...result, ...subResult];
    }
  });

  return result;
};
