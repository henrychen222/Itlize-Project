import React, { useState, useEffect, useRef } from 'react';

import styles from './Header.module.sass';
import List from '../../Icons/List';
import JumpRightUp from '../../Icons/JumpRightUp';
import SelectState from '../../Icons/SelectState';
import CheckboxNoSelected from '../../Icons/CheckboxNoSelected';

export function ResourceHeader({ setSelectResources, setExportCurrent }) {
  const [toggleList, setToggleList] = useState(false);
  const listDropdownRef = useRef(null);

  useEffect(() => {
    const handleClickOutside = event => {
      if (
        toggleList &&
        listDropdownRef.current &&
        !listDropdownRef.current.contains(event.target)
      ) {
        setToggleList(false);
      }
    };

    const handleEscKey = event =>
      toggleList && event.keyCode === 27 ? setToggleList(false) : null;

    document.addEventListener('mousedown', handleClickOutside);
    document.addEventListener('keydown', handleEscKey);

    return () => {
      document.removeEventListener('mousedown', handleClickOutside);
      document.removeEventListener('keydown', handleEscKey);
    };
  }, [toggleList]);

  return (
    <header className={styles.header}>
      <p>Resource Catalog</p>

      <div ref={listDropdownRef} className={styles.dropdown}>
        <List onClick={() => setToggleList(!toggleList)} />
        <ul
          style={{
            display: toggleList ? 'inherit' : 'none',
            height: toggleList ? 'auto' : 0
          }}
        >
          <li
            onClick={() => {
              setToggleList(false);
              setSelectResources('all');
            }}
          >
            <SelectState /> Select all
          </li>
          <li
            onClick={() => {
              setToggleList(false);
              setSelectResources('none');
            }}
          >
            <CheckboxNoSelected /> Clear selection
          </li>
        </ul>
      </div>

      <JumpRightUp onClick={() => setExportCurrent({ start: true })} />
    </header>
  );
}
