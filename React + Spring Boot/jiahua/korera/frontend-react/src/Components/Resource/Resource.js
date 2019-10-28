import React, { useState, useRef, useEffect, useReducer } from 'react';

import {
  resource,
  edit,
  off,
  none,
  parent,
  addingRow,
  addingColumn,
  csvBottomDiv,
  newCsvPart
} from './Resource.module.sass';
import Magnifier from '../../Icons/Magnifier';
import Plus from '../../Icons/Plus';
import Left from '../../Icons/Left';
import Column from '../../Icons/Column';
import Csv from '../../Icons/Csv';
import Check from '../../Icons/Check';
import No from '../../Icons/No';
import {
  formatHeader,
  actionTypes,
  reducer,
  initLoad,
  getSign,
  shouldDisplay,
  handleAddRow,
  handleAddColumnInput,
  handleAddColumn
} from '../../utils/data/resource.process';
import { updateResources } from '../../utils/api/api';

export function Resource() {
  const [search, setSearch] = useState('');
  const [toggle, setToggle] = useState(false);
  const ref = useRef(null);
  const [tableHead, setTableHead] = useState(new Set());
  const [state, dispatch] = useReducer(reducer, {});
  const [addRow, setAddRow] = useState(false);
  const addRowRef = useRef(null);
  const [addColumn, setAddColumn] = useState({ on: false });
  const csvFileUpload = useRef(null);
  const [addingCsv, setAddingCsv] = useState({ on: false });

  useEffect(() => {
    initLoad(setTableHead, dispatch);
  }, []);

  useEffect(() => {
    const handleClickOutside = event => {
      if (toggle && ref.current && !ref.current.contains(event.target)) {
        setToggle(false);
      }
    };

    const handleEscKey = event =>
      toggle && event.keyCode === 27 ? setToggle(false) : null;

    document.addEventListener('mousedown', handleClickOutside);
    document.addEventListener('keydown', handleEscKey);

    return () => {
      document.removeEventListener('mousedown', handleClickOutside);
      document.removeEventListener('keydown', handleEscKey);
    };
  }, [toggle]);

  const handleCsvUpload = async (
    event,
    tableHead,
    setAddingCsv,
    setTableHead
  ) => {
    const csvFile = event.target.files[0];
    event.target.value = null; // need to reset, otherwise upload twice same file will be broken
    if (csvFile.type === 'application/vnd.ms-excel') {
      const fileReader = new FileReader();
      const uploadedResources = [];

      fileReader.onloadend = event => {
        const csvContent = event.target.result;
        let [needHeader, headerNames] = [true, null];
        for (let line of csvContent.split(/\r\n|\r|\n/g)) {
          if (needHeader) {
            headerNames = line.split(',');
            for (let [index, name] of headerNames.entries()) {
              if (!['name', 'cost_code'].includes(name)) {
                const foundName = [...tableHead].find(headerName =>
                  headerName.includes(name)
                );
                if (foundName) {
                  headerNames[index] = foundName;
                }
              }
            }

            needHeader = false;
          } else {
            const newResource = { name: '', cost_code: '', data: {} };
            const currentRow = line.split(',');
            for (let [index, value] of currentRow.entries()) {
              const currentName = headerNames[index];
              if (['name', 'cost_code'].includes(currentName)) {
                newResource[currentName] = value;
              } else {
                newResource.data[currentName] = value;
              }
            }

            uploadedResources.push(newResource);
          }
        }

        const newTableHead = new Set(tableHead);
        headerNames.forEach(name => newTableHead.add(name));
        setAddingCsv(values => ({
          ...values,
          on: true,
          prevTableHead: tableHead,
          uploadedResources: uploadedResources
        }));
        setTableHead(newTableHead);
      };

      fileReader.readAsText(csvFile);
    } else {
      alert('Only allow csv file format');
    }
  };

  return (
    <div className={resource}>
      <header>
        <form>
          <input
            value={search}
            onChange={event => setSearch(event.target.value)}
            type="text"
            placeholder="Keyword"
          />
          <Magnifier fill="white" />
        </form>

        <p>Resource Catalog</p>

        <div ref={ref} className={edit}>
          <Plus onClick={() => setToggle(!toggle)} fill="white" />
          <ul className={toggle ? '' : off}>
            <li
              onClick={() => {
                setToggle(false);
                setAddColumn({ on: false });
                if (addingCsv.on) {
                  setTableHead(addingCsv.prevTableHead);
                  setAddingCsv({ on: false });
                }
                setAddRow(true);
              }}
            >
              <Left /> Add Row
            </li>
            <li
              onClick={() => {
                setToggle(false);
                setAddRow(false);
                if (addingCsv.on) {
                  setTableHead(addingCsv.prevTableHead);
                  setAddingCsv({ on: false });
                }
                setAddColumn({ on: true });
              }}
            >
              <Column /> Add Column
            </li>
            <li
              onClick={() => {
                setToggle(false);
                setAddRow(false);
                setAddColumn({ on: false });
                csvFileUpload.current.click();
              }}
            >
              <Csv />
              Import CSV
              <input
                style={{ display: 'none' }}
                ref={csvFileUpload}
                type="file"
                accept=".csv"
                onChange={event =>
                  handleCsvUpload(event, tableHead, setAddingCsv, setTableHead)
                }
              />
            </li>
          </ul>
        </div>
      </header>

      <div>
        <table>
          <thead>
            <tr>
              <th>RESOURCE NAME</th>
              {addColumn.on ? (
                <th className={addingColumn}>
                  <div>
                    <Check
                      onClick={() =>
                        handleAddColumn(
                          addColumn,
                          tableHead,
                          state,
                          setTableHead,
                          dispatch,
                          setAddColumn
                        )
                      }
                    />
                    <No onClick={() => setAddColumn({ on: false })} />
                    <input
                      name="name"
                      onChangeCapture={event =>
                        handleAddColumnInput(event, setAddColumn)
                      }
                      type="text"
                    />
                  </div>
                </th>
              ) : null}
              <th>RESOURCE CODE</th>
              {[...tableHead].map(name => (
                <th key={name}>{formatHeader(name)}</th>
              ))}
            </tr>
          </thead>
          <tbody>
            {addRow ? (
              <tr className={addingRow} ref={addRowRef}>
                <td>
                  <div>
                    <Check
                      onClick={() =>
                        handleAddRow(
                          addRowRef,
                          setTableHead,
                          dispatch,
                          setAddRow
                        )
                      }
                    />
                    <No
                      onClick={() => {
                        setAddRow(false);
                      }}
                    />
                    <input type="text" name="name" placeholder="name" />
                  </div>
                </td>

                <td>
                  <div>
                    <input
                      type="text"
                      name="cost_code"
                      placeholder="cost code"
                    />
                  </div>
                </td>
                {[...tableHead].map(name => (
                  <td key={name}>
                    <div>
                      <input
                        name={name}
                        type="text"
                        placeholder={formatHeader(name)}
                      />
                    </div>
                  </td>
                ))}
              </tr>
            ) : null}

            {state.resources &&
              state.resources.map((row, index) => (
                <tr
                  className={shouldDisplay(row, search, none, parent)}
                  key={row.id}
                >
                  <td
                    onClick={
                      row.is$parent
                        ? () =>
                            dispatch({
                              type: actionTypes.toggle,
                              resource: row
                            })
                        : null
                    }
                    style={{
                      paddingLeft: row.padding$level * 10
                    }}
                  >
                    {row.is$parent ? getSign(row, state) : ''}
                    {row.name}
                  </td>
                  {addColumn.on ? (
                    <td>
                      <input
                        name={index}
                        onChangeCapture={event =>
                          handleAddColumnInput(event, setAddColumn)
                        }
                        type="text"
                      />
                    </td>
                  ) : null}
                  <td>{row.cost_code}</td>
                  {[...tableHead].map(name => (
                    <td key={`${row.id} ${name}`}> {row.data[name]} </td>
                  ))}
                </tr>
              ))}

            {addingCsv.on &&
              addingCsv.uploadedResources.map(row => (
                <tr className={newCsvPart} key={`${row.name} ${row.cost_code}`}>
                  <td>{row.name}</td>
                  <td>{row.cost_code}</td>
                  {[...tableHead].map(name => (
                    <td key={`${row.name} ${row.cost_code} ${name}`}>
                      {row.data[name]}
                    </td>
                  ))}
                </tr>
              ))}
          </tbody>
        </table>
      </div>
      <div className={csvBottomDiv}>
        {addingCsv.on && (
          <>
            Add CSV?
            <Check
              onClick={async () => {
                await updateResources(addingCsv.uploadedResources);
                setAddingCsv({ on: false });
                await initLoad(setTableHead, dispatch);
              }}
            />
            <No
              onClick={() => {
                setTableHead(addingCsv.prevTableHead);
                setAddingCsv({ on: false });
              }}
            />
          </>
        )}
      </div>
    </div>
  );
}
