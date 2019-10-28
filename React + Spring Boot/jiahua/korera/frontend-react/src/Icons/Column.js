import React from "react";

const SvgColumn = props => (
  <svg
    className="column_svg__icon"
    viewBox="0 0 1024 1024"
    width={200}
    height={200}
    {...props}
  >
    <defs>
      <style />
    </defs>
    <path d="M128 877.714h347.429V219.43H109.714v640q0 7.46 5.413 12.873T128 877.714zm786.286-18.285v-640H548.57v658.285H896q7.46 0 12.873-5.412t5.413-12.873zm73.143-694.858V859.43q0 37.741-26.844 64.585T896 950.857H128q-37.742 0-64.585-26.843T36.57 859.429V164.57q0-37.741 26.844-64.585T128 73.143h768q37.742 0 64.585 26.843t26.844 64.585z" />
  </svg>
);

export default SvgColumn;
