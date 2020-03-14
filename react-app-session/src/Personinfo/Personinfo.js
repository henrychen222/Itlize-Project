import React, {Component} from 'react';
import Radium from 'radium';
import Aux from '../hoc/Aux';
import classAux from '../hoc/classAux';
import PropTypes from 'prop-types';

import styles from './Person.css';

class person extends Component {

  componentDidMount() {
    if (this.props.index == 0) {
      this.inputElement.focus()
    }
  }

  render() {
    const style={
      '@media (min-width:700px)' : {
        width:'500px'
      }
    }
    return (
      // <div className={styles.Person} style={style}>
      //   <p onClick={this.props.click}>I am {this.props.name}, I am a {this.props.job} and I am {this.props.age} years old</p>
      //   <p>{this.props.children} </p>
      //   <input className="form-control" type="text" value={this.props.name} onChange={this.props.change}/>
      // </div>

      <Aux>
        <p onClick={this.props.click}>I am {this.props.name}, I am a {this.props.job} and I am {this.props.age} years old</p>
        <p>{this.props.children} </p>
        <input className="form-control"
               type="text"
               ref={(input)=> {this.inputElement = input}}
               value={this.props.name}
               onChange={this.props.change}/>
      </Aux>
    )
  }
}

// const person = (this.props) => {
//   const style={
//     '@media (min-width:700px)' : {
//       width:'500px'
//     }
//   }
//   return (
//     // <div className={styles.Person} style={style}>
//     //   <p onClick={this.props.click}>I am {this.props.name}, I am a {this.props.job} and I am {this.props.age} years old</p>
//     //   <p>{this.props.children} </p>
//     //   <input className="form-control" type="text" value={this.props.name} onChange={this.props.change}/>
//     // </div>
//
//     <Aux>
//       <p onClick={this.props.click}>I am {this.props.name}, I am a {this.props.job} and I am {this.props.age} years old</p>
//       <p>{this.props.children} </p>
//       <input className="form-control" type="text" value={this.props.name} onChange={this.props.change}/>
//     </Aux>
//   )
// }

person.propTypes = {
  click: PropTypes.func,
  name: PropTypes.string,
  job: PropTypes.string,
  age: PropTypes.number,
  changed: PropTypes.func,

}

export default classAux(person, styles.Person);
