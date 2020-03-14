const redux = require ('redux');
const createStore = redux.createStore;

const initialState = {
  name:"stephan"
}

//reducer
const rootReducer = (state = initialState, action) => {
  if (action.type == 'PUSH_NAME') {
    return {
      ...state,
      name:state.name+ " and "
    }
  }

  if (action.type == 'CHANGE_NAME') {
    return {
      ...state,
      name:state.name + action.value
    }
  }
  return state

};

//store
const store = createStore(rootReducer);
console.log(store.getState());

// subscription
store.subscribe(() => {
  console.log('subscription', store.getState())
})


// dispaching action
store.dispatch({type:'PUSH_NAME'});
store.dispatch({type:'CHANGE_NAME', value:'Alvin'});
console.log(store.getState());
