import React, { useState } from 'react';
import { Link } from 'react-router-dom';

import styles from './Formula.module.sass';
import { ProjectIdPanel } from '../../utils/ProjectIdPanel/ProjectIdPanel';
import PureCheck from '../../Icons/PureCheck';
import { MainTable } from './MainTable';

export function Formula() {
  const [chosenProjectId, setChosenProjectId] = useState(0);
  const [submitted, setSubmitted] = useState(false);

  return (
    <div className={styles.formula}>
      <header>
        <ProjectIdPanel value={chosenProjectId} setter={setChosenProjectId} />
      </header>

      <MainTable
        chosenProjectId={chosenProjectId}
        submitted={submitted}
        setSubmitted={setSubmitted}
      />

      <footer>
        <Link to="template">Edit Quantity Survey Template</Link>
        <button type="submit" onClick={() => setSubmitted(true)}>
          <PureCheck /> Submit
        </button>
      </footer>
    </div>
  );
}
