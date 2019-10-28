import React, { useState } from 'react';
import { Link } from 'react-router-dom';

import styles from './Project.module.sass';
import { ProjectIdPanel } from '../../utils/ProjectIdPanel/ProjectIdPanel';
import PureCheck from '../../Icons/PureCheck';
import { ResourceSection } from './ResourceSection';
import { ProjectSection } from './ProjectSection';

export function Project() {
  const [chosenProjectId, setChosenProjectId] = useState(0);
  const [exportCurrent, setExportCurrent] = useState({ start: false });
  const [submitted, setSubmitted] = useState(false);

  return (
    <div className={styles.project}>
      <header>
        <ProjectIdPanel value={chosenProjectId} setter={setChosenProjectId} />
      </header>
      <main>
        <ResourceSection
          exportCurrent={exportCurrent}
          setExportCurrent={setExportCurrent}
        />
        <ProjectSection
          chosenProjectId={chosenProjectId}
          exportCurrent={exportCurrent}
          setExportCurrent={setExportCurrent}
          submitted={submitted}
          setSubmitted={setSubmitted}
        />
      </main>
      <footer>
        <Link to="resource">Edit Resource</Link>
        <button type="submit" onClick={() => setSubmitted(true)}>
          <PureCheck /> Submit
        </button>
      </footer>
    </div>
  );
}
