import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

import Personinfo from './Personinfo/Personinfo';

class App extends Component {

  state = {
    persons:[
      {id:1,name:"Stephan",job:"MEAN developer",age:27},
      {id:2,name:"alvin", job:".NET developer",age:30},
      {id:3,name:"shane", job:"BA", age:30}
    ],
    other_persons:'whatever',
    showperson:false
  }

  changename = (updatedName) => {
    // this.state.persons[0].name = "new Stephan"
    this.setState({
      persons:[
        {name:updatedName,job:"MEAN developer", age:18},
        {name:"alvin", job:".NET developer", age:20},
        {name:"shane", job:"BA", age:19}
      ]
    })
  }

  deletePerson = (personIndex) => {
    const persons = [...this.state.persons];
    persons.splice(personIndex, 1);
    this.setState({persons:persons})
  }

  bindingName = (event, id) => {
    const personIndex = this.state.persons.findIndex(p => {
      return p.id === id
    });
    const person = {...this.state.persons[personIndex]};
    person.name = event.target.value;
    const persons = [...this.state.persons];
    persons[personIndex] = person;

    this.setState({
      persons:persons
    })
  }

  togglePerson = () => {
    const togglePerson = this.state.showperson;
    this.setState({
      showperson:!togglePerson
    })

  }

  render() {
    const style = {
      backgroungColor: 'white',
      font:'inherit',
      border:'1px solid rgb(19, 150, 235)',
      padding:'8px'
    };

    let personinfo = null;

    if (this.state.showperson) {

      personinfo = (
        (
          <div>
            {this.state.persons.map((person, index) => {
              return <Personinfo name={person.name}
                      age={person.age}
                      job={person.job}
                      key={person.id}
                      click={()=>this.deletePerson(index)}
                      change={(event)=>{this.bindingName(event, person.id)}}/>
            })}
          </div>
        )
      )

      // <div>
      //   <Personinfo name={this.state.persons[0].name}
      //   job={this.state.persons[0].job}/>
      //
      //   <Personinfo
      //   change={this.bindingName}
      //   name={this.state.persons[1].name}
      //   job={this.state.persons[1].job}> I am 30 years old.</Personinfo>
      //
      //   <Personinfo name={this.state.persons[2].name}
      //   job={this.state.persons[2].job}/>
      // </div>
    } else {
      personinfo = null
    }

    let classes = [];   //array
    if (this.state.persons.length <=2) {
      classes.push('blue');     //classes: ['red']
    }
    if (this.state.persons.length <=1) {
      classes.push('bold')
    }

    return (

      <div className="App">
        <h1>Hello World</h1>
        <p className={classes.join(' ')}>
          this is react sesion
        </p>


        { this.state.showperson ?
          <div>
            <button style={style} onClick={()=>this.changename('new name')}>change name</button>
          </div> : null
        }
        <br/><br/>
        <div>
          <button style={style} onClick={this.togglePerson}> Toggle Person</button>
        </div>
        {personinfo}

      </div>
    );
  }
}

export default App;
