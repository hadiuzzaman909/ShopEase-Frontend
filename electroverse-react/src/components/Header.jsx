import React from 'react'
import { Link } from 'react-router-dom'; 
import logo from '../assets/shopease.png'

function Header() {

      return (
        <div >
        <nav className="navbar">
          <div className="navbar-left">
            <Link to="/">
              <span className="logo-text">
                <span className="shop">Shop</span>
                <span className="ease">Ease</span>
              </span>
            </Link>
          </div>
    
          <div className="navbar-middle">
            <ul className="menu">
              <li><Link to="/products">Products</Link></li>
              <li><Link to="/deals">Deals</Link></li>
              <li><Link to="/new-arrivals">New Arrivals</Link></li>
              <li><Link to="/brands">Brands</Link></li>
            </ul>
          </div>
    
          <div className="navbar-right">
            <ul className="right-menu">
              <li><Link to="/wishlist"><i class="icon-s20 ri-heart-line"></i></Link></li>
              <li><Link to="/cart"><i class="ri-shopping-cart-fill"></i></Link></li>
              <li><Link to="/account"><i class="icon-s20 ri-user-line"></i></Link></li>
              <li><Link to="/login">Login</Link></li>
              <li><Link to="/register">Register</Link></li>
            </ul>
          </div>
        </nav>
        </div>

      );
    }
    
    export default Header;
    

