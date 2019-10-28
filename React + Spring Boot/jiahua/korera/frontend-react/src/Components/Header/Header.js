import React, { useState, useRef, useEffect } from 'react';
import { connect } from 'react-redux';
import moment from 'moment';

import { header, panel, info, popup, hide, click } from './Header.module.sass';
import BaselineAccountCircle24Px from '../../Icons/BaselineAccountCircle24Px';
import Wrench from '../../Icons/Wrench';
import { logout } from '../../utils/redux/actions';

export function Header({ user, dispatch }) {
  const [show, setShow] = useState(false);
  const ref = useRef(null);

  useEffect(() => {
    const handleClickOutside = event => {
      if (show && ref.current && !ref.current.contains(event.target)) {
        setShow(false);
      }
    };

    const handleEscKey = event =>
      show && event.keyCode === 27 ? setShow(false) : null;

    document.addEventListener('mousedown', handleClickOutside);
    document.addEventListener('keydown', handleEscKey);

    return () => {
      document.removeEventListener('mousedown', handleClickOutside);
      document.removeEventListener('keydown', handleEscKey);
    };
  }, [show]);

  return (
    <header className={header}>
      <div className={panel}>
        <Wrench /> <p>Resource Management</p>
      </div>

      <div className={info}>
        <div ref={ref}>
          <BaselineAccountCircle24Px
            className={user ? click : null}
            onClick={() => setShow(!show)}
          />

          {user ? (
            <div className={show ? popup : `${popup} ${hide}`}>
              <div>
                <p>{user.username}</p>
                <p>Member since</p>
                <p>{moment(user.joined).format('MMMM-YYYY')}</p>
              </div>
              <div>
                <button>profile</button>
                <span />
                <button onClick={() => dispatch(logout())}>sign out</button>
              </div>
            </div>
          ) : null}
        </div>
        {user ? user.username : null}
      </div>
    </header>
  );
}

const mapStateToProps = ({ user }) => ({ user });

export default connect(mapStateToProps)(Header);
