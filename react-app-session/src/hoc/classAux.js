import React from 'react';

const classAux = (WrappedComponent, className) => {
  return (props) => (
    <div className = {className}>
      <WrappedComponent {...props}/>
    </div>
  )
}

export default classAux;



