import React, { useState } from 'react';

import { ResourceHeader } from './ResourceHeader';
import { ResourceTable } from './ResourceTable';

export function ResourceSection({ exportCurrent, setExportCurrent }) {
  const [selectResources, setSelectResources] = useState('');

  return (
    <section>
      <ResourceHeader
        setSelectResources={setSelectResources}
        setExportCurrent={setExportCurrent}
      />
      <ResourceTable
        selectResources={selectResources}
        setSelectResources={setSelectResources}
        exportCurrent={exportCurrent}
        setExportCurrent={setExportCurrent}
      />
    </section>
  );
}
