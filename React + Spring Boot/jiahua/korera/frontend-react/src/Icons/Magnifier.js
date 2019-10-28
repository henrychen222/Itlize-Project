import React from "react";

const SvgMagnifier = props => (
  <svg
    className="magnifier_svg__icon"
    viewBox="0 0 1024 1024"
    width={200}
    height={200}
    {...props}
  >
    <defs>
      <style />
    </defs>
    <path d="M450.54 835.422c-212.445 0-385.282-172.836-385.282-385.275 0-212.436 172.837-385.273 385.283-385.273 212.446 0 385.29 172.837 385.29 385.273 0 212.438-172.844 385.275-385.29 385.275zm0-675.716c-160.156 0-290.446 130.292-290.446 290.441 0 160.15 130.29 290.444 290.447 290.444 160.155 0 290.453-130.294 290.453-290.444 0-160.149-130.298-290.441-290.453-290.441z" />
    <path d="M900.538 958.478c-14.94 0-29.87-5.7-41.27-17.09l-201.29-201.275c-22.789-22.79-22.789-59.741 0-82.536 22.799-22.783 59.744-22.783 82.54 0l201.29 201.275c22.79 22.79 22.79 59.74 0 82.534-11.4 11.392-26.33 17.092-41.27 17.092" />
  </svg>
);

export default SvgMagnifier;
