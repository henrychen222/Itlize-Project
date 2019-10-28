import React, { useState } from 'react';

import styles from './Template.module.sass';
import { ProjectIdPanel } from '../../utils/ProjectIdPanel/ProjectIdPanel';
import { Survey } from './Survey';

export function Template() {
  const [chosenProjectId, setChosenProjectId] = useState(0);
  const [submitted, setSubmitted] = useState(false);

  return (
    <div className={styles.template}>
      <header>
        <ProjectIdPanel value={chosenProjectId} setter={setChosenProjectId} />
      </header>

      <Survey
        chosenProjectId={chosenProjectId}
        submitted={submitted}
        setSubmitted={setSubmitted}
      />

      <footer>
        <button type="submit" onClick={() => setSubmitted(true)}>
          Save
        </button>
      </footer>
    </div>
  );
}
