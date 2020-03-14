import React, { Component } from 'react';
// import logo from './logo.svg';


import styles from './App.css';



import Radium, {StyleRoot} from 'radium';

import Personinfo from './Personinfo/Personinfo';

class App extends Component {

  state = {
    persons:[
      {id:1,name:"Stephan",job:"MEAN developer",age:27},
      {id:2,name:"alvin", job:".NET developer",age:30},
      {id:3,name:"shane", job:"BA", age:30}
    ],
    other_persons:'whatever',
    showperson:false,
    clickTime:0
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
    this.setState( (prevState, props ) => {
      console.log(prevState);
      console.log(props);
      return {
      showperson:!togglePerson,
      clickTime: prevState.clickTime + 1
    }
  })
    console.log(this.state.clickTime)
  }

  render() {
    const style = {
      backgroungColor: 'white',
      font:'inherit',
      border:'1px solid rgb(19, 150, 235)',
      padding:'8px',
      ':hover':{
        color:'white',
        backgroundColor:'blue'
      }
    };

    let personinfo = null;

    if (this.state.showperson) {

      personinfo = (
        (
          <div>
            {this.state.persons.map((person, index) => {
              return <Personinfo name={person.name}
                      age={person.age}
                      index= {index}
                      job={person.job}
                      key={person.id}
                      click={()=>this.deletePerson(index)}
                      change={(event)=>{this.bindingName(event, person.id)}}/>
            })}
          </div>
        )
      )

      style[':hover'] = {
        color: 'rgb(246, 80, 80)',
        backgroundColor:'lightgreen'
      }

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
      classes.push(styles.blue);    //classes:['App__blue__3CWHK']
    }
    if (this.state.persons.length <=1) {
      classes.push(styles.bold)
      console.log(classes);
    }

    return (
      <StyleRoot>
        <div className={styles.App}>
          <h1>Hello World</h1>
          <p className={classes.join(' ')}>
            this is react sesion
          </p>


          { this.state.showperson ?
            <div>
              <button key="changeName" style={style} onClick={()=>this.changename('new name')}>change name</button>
            </div> : null
          }
          <br/><br/>
          <div>
            <button key="toggleName" style={style} onClick={this.togglePerson}> Toggle Person</button>
          </div>
          {personinfo}

        </div>
      </StyleRoot>
    );
  }
}

export default Radium(App);
