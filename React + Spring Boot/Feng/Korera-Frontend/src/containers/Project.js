import React, { Component } from 'react';
import { connect } from 'react-redux';
// import ReactTable from 'react-table';
import "react-table/react-table.css";
import { setResource, addRow, addColumn,
        addSelected, deleteSelected, saveSelected } from "../redux/actions/actionCreators";
// import "./Resource.css";
import SelectTable from '../components/SelectableTable/SelectableTable';
import './Project.css';

class Project extends Component {

    state = {
        selection: [],
        selectAll: false
    }

    toggleSelection = (key, shift, row) => {
        /*
          Implementation of how to manage the selection state is up to the developer.
          This implementation uses an array stored in the component state.
          Other implementations could use object keys, a Javascript Set, or Redux... etc.
        */
        // start off with the existing state
      
          let selection = [...this.state.selection];
          const keyIndex = selection.indexOf(key);
          // check to see if the key exists
          if (keyIndex >= 0) {
            // it does exist so we will remove it using destructing
            selection = [
              ...selection.slice(0, keyIndex),
              ...selection.slice(keyIndex + 1)
            ];
          } else {
            // it does not exist so add it
            selection.push(key);
          }
          // update the state
          this.setState({ selection });
        
      };

      isSelected = key => {
        /*
          Instead of passing our external selection state we provide an 'isSelected'
          callback and detect the selection state ourselves. This allows any implementation
          for selection (either an array, object keys, or even a Javascript Set object).
        */
        return this.state.selection.includes(key);
      };

      logSelection = () => {
        console.log("selection:", this.state.selection);
      };

      toggleAll = () => {
          const selectAll = !this.state.selectAll;
          const selection = [];
          if(selectAll) {
            this.props.resource.forEach(e => {
                selection.push(e.id);
            })
          }
          this.setState({selectAll, selection});
      }

      handleSubmit = (selectedResource) => {
          this.props.saveSelected(selectedResource);
          this.props.history.push('/formula');
      }



      render() {

        //put variables like this in state or just in render??
        const selectedResource = this.props.resource.filter(
            resource => this.props.selected.includes(resource.id)
        );


        // console.log(selectedResource);
        return (
        <div className='project-container'>
            <div className='table-project'>
                <SelectTable resource={this.props.resource}
                columns={this.props.columns}
                add={this.props.addSelected}
                selection={this.props.selected}
                profile={true}
                header='Resource Catelog'/>
            </div>
            <div className='table-project'>
                <SelectTable resource={selectedResource}
                columns={this.props.columns}
                delete={this.props.deleteSelected}
                header='Project'/>
            </div>
            <button 
            onClick={() => this.handleSubmit(selectedResource)}
            disabled={this.props.selected.length === 0}>Submit</button>
        </div>);
      }

//    render() {
//          const data = this.props.resource;
//         const columns = [...this.props.columns];
//         //columns
//         columns.unshift({
//             Header: "",
//             accessor: 'id',
//             Cell: row => (
//                 <input type="checkbox" onChange={e => this.toggleSelection(row.original.id)}
//                 checked={this.isSelected(row.original.id)}
//                 />
//             ),
//             width: 20
//         })
//         console.log(columns);
//         return (<div className="table-container">
//         <button onClick={this.logSelection}>Log Selection to Console</button>
//         <input type="checkbox" checked={this.state.selectAll} onChange={this.toggleAll}/> Select All
//             <ReactTable 
//             data={data} 
//             columns={columns}
//             />
//         </div>);
//     }
}

const mapDispatchToProps = dispatch => {
    return {
        setResource: (resource) => dispatch(setResource(resource)),
        addRow: () => dispatch(addRow()),
        addColumn: (name) => dispatch(addColumn(name)),
        addSelected: (selection) => dispatch(addSelected(selection)),
        deleteSelected: (selection) => dispatch(deleteSelected(selection)),
        saveSelected: (selectedData) => dispatch(saveSelected(selectedData))
    }
}

const mapStateToProps = ({ resource: {data, columns, selected }}) => {
    return {resource: data, columns, selected};
}

export default connect(mapStateToProps, mapDispatchToProps)(Project);