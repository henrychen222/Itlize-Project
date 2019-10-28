import React from "react";

const SvgCheckboxNoSelected = props => (
  <svg
    className="checkbox-no_selected_svg__icon"
    viewBox="0 0 1024 1024"
    width={16}
    height={16}
    {...props}
  >
    <defs>
      <style />
    </defs>
    <path
      d="M160 32h704a128 128 0 0 1 128 128v704a128 128 0 0 1-128 128H160A128 128 0 0 1 32 864V160A128 128 0 0 1 160 32zm0 64a64 64 0 0 0-64 64v704a64 64 0 0 0 64 64h704a64 64 0 0 0 64-64V160a64 64 0 0 0-64-64H160z"
      fill="#8a8a8a"
    />
  </svg>
);

export default SvgCheckboxNoSelected;
