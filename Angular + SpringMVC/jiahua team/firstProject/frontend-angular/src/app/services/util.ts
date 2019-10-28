export const attrPairPreProcessor = ([key, value]) => {
  const arr = key.split('.');
  const type = arr[arr.length - 1].toUpperCase();
  if (type === 'MAX' || type === 'MIN') {
    value = +value;
  }
  return [arr, value];
};

export const attrTransform = (arr: any[], value: string | number) => {
  const result = {};
  let pointer: any = result;

  arr.forEach((key, index) => {
    if (index === arr.length - 1) {
      pointer[key] = value;
    } else {
      pointer[key] = {};
    }
    pointer = pointer[key];
  });

  return result;
};

export const attrTransformInPlace = (
  arr: any[],
  value: string | number,
  src: any
) => {
  let pointer = src;
  arr.forEach((key, index) => {
    if (index === arr.length - 1) {
      pointer[key] = value;
    } else {
      if (!(key in pointer)) {
        pointer[key] = {};
      }
    }
    pointer = pointer[key];
  });
};
