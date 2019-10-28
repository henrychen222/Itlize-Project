import React from "react";

const SvgArrowRight = props => (
  <svg
    className="arrow_right_svg__icon"
    viewBox="0 0 1024 1024"
    width={16}
    height={16}
    {...props}
  >
    <defs>
      <style />
    </defs>
    <path
      d="M85.333 512h832-832zM501.333 928l416-416-416-416z"
      fill="#2c2c2c"
    />
  </svg>
);

export default SvgArrowRight;
