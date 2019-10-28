import React, { useState, useEffect, useRef } from 'react';

import { getProjectIds } from '../api/api';
import styles from './ProjectIdPanel.module.sass';
import ArrowDropDown from '../../Icons/ArrowDropDown';
import Magnifier from '../../Icons/Magnifier';

export function ProjectIdPanel({ value, setter }) {
  const [projectIds, setProjectIds] = useState([1, 2, 3, 4]);
  const [filterProjectId, setFilterProjectId] = useState('');
  const [dropDown, setDropDown] = useState(false);
  const ref = useRef(null);

  useEffect(() => {
    const handleClickOutside = event => {
      if (dropDown && ref.current && !ref.current.contains(event.target)) {
        setDropDown(false);
      }
    };

    const handleEscKey = event =>
      dropDown && event.keyCode === 27 ? setDropDown(false) : null;

    document.addEventListener('mousedown', handleClickOutside);
    document.addEventListener('keydown', handleEscKey);

    return () => {
      document.removeEventListener('mousedown', handleClickOutside);
      document.removeEventListener('keydown', handleEscKey);
    };
  }, [dropDown]);

  useEffect(() => {
    const loadProjectIds = async () => {
      const result = await getProjectIds();
      if (result.length) {
        setProjectIds(result);
        setter(result[0]);
      }
    };

    if (true) {
      // TODO? for convenient development, lock available project ids
      // since there is no obvious explicit add project Id somewhere
      setter(1);
    } else {
      loadProjectIds();
    }
  }, [setter]);

  return (
    <div ref={ref} className={styles.container}>
      <span onClick={() => setDropDown(!dropDown)}>Project {value} </span>
      <ArrowDropDown onClick={() => setDropDown(!dropDown)} />

      <div
        style={{
          display: dropDown ? 'inherit' : 'none'
        }}
      >
        <div>
          <input
            value={filterProjectId}
            onChange={event => setFilterProjectId(event.target.value)}
            type="text"
          />
          <Magnifier />
        </div>
        <ul>
          {projectIds.map(id => (
            <li
              style={{
                display: `PROJECT ${id}`.includes(filterProjectId.toUpperCase())
                  ? 'inherit'
                  : 'none'
              }}
              key={id}
              onClick={() => {
                setter(id);
                setDropDown(false);
              }}
            >
              Project {id}
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}
