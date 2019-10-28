export const actions = { update: 'update', valid: 'valid' };

export const reducer = (state, action) => {
  switch (action.type) {
    case actions.update:
      return {
        ...state,
        [action.field]: {
          ...state[action.field],
          value: action.payload,
          touched: true
        }
      };
    case actions.valid:
      if (state[action.field].valid === action.payload) {
        return state;
      }

      return {
        ...state,
        [action.field]: { ...state[action.field], valid: action.payload }
      };
    default:
      return state;
  }
};
