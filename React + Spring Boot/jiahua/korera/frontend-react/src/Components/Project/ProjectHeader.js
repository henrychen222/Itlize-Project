import React from 'react';

import styles from './Header.module.sass';
import Trash from '../../Icons/Trash';

export function ProjectHeader({ setTrash }) {
  return (
    <header
      style={{
        gridTemplateColumns: '1fr max-content'
      }}
      className={styles.header}
    >
      <p>Project</p>
      <Trash onClick={() => setTrash(true)} />
    </header>
  );
}
