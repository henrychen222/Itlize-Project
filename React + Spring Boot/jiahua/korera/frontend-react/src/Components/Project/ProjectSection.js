import React, { useState } from 'react';

import { ProjectHeader } from './ProjectHeader';
import { ProjectTable } from './ProjectTable';

export function ProjectSection({
  chosenProjectId,
  exportCurrent,
  setExportCurrent,
  submitted,
  setSubmitted
}) {
  const [trash, setTrash] = useState(false);

  return (
    <section>
      <ProjectHeader setTrash={setTrash} />
      <ProjectTable
        chosenProjectId={chosenProjectId}
        exportCurrent={exportCurrent}
        setExportCurrent={setExportCurrent}
        trash={trash}
        setTrash={setTrash}
        submitted={submitted}
        setSubmitted={setSubmitted}
      />
    </section>
  );
}
