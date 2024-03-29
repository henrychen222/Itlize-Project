import React from "react";

const SvgNo = props => (
  <svg
    className="no_svg__icon"
    viewBox="0 0 1024 1024"
    width={128}
    height={128}
    {...props}
  >
    <defs>
      <style />
    </defs>
    <path
      d="M512 37.312C249.856 37.312 37.312 249.792 37.312 512c0 262.208 212.544 474.688 474.688 474.688 262.208 0 474.688-212.48 474.688-474.688 0-262.144-212.48-474.688-474.688-474.688zm182.784 687.68L512.448 546.688 330.24 733.056l-51.136-50.176 182.144-186.304-182.144-177.984 49.984-51.2L511.296 445.44 685.568 267.2l51.136 50.048-174.272 178.24 182.4 178.432-50.048 51.072z"
      fill="#ff8e31"
    />
  </svg>
);

export default SvgNo;
