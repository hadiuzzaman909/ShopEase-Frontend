import React from 'react'

function Footer() {
  return (
    <div class="footer">
    <div class="container d-flex flex-column justify-content-center">
        
      
        <div class="footer-top">
            <div class="contact-info">
                <div class="footer-block footer-item">
                    <div class="logo">
                     
                        <img src="path-to-your-logo.png" alt="ShopEase Logo" />
                    </div>
                    <div class="contact-details">
                        <p><strong>Address:</strong> 1234 Fashion Street, Suite 567, New York, NY 10001</p>
                        <p><strong>Email:</strong> <a href="mailto:info@shopease.com">info@shopease.com</a></p>
                        <p><strong>Phone:</strong> <a href="tel:+12125551234">(212) 555-1234</a></p>
                    </div>
                </div>
                <div class="footer-block footer-item">
                    <div class="social-buttons">
                     
                        <a href="https://facebook.com" class="social-button">Facebook</a>
                        <a href="https://twitter.com" class="social-button">Twitter</a>
                        <a href="https://instagram.com" class="social-button">Instagram</a>
                    </div>
                </div>
            </div>
            
  
            <div class="footer-info">
                <div class="service-info">
                    <div class="footer-block footer-item">
                        <strong>Information</strong>
                        <ul class="list">
                            <li><a href="/sitemap">Sitemap</a></li>
                            <li><a href="/contact-us">Contact Us</a></li>
                            <li><a href="/about">About Us</a></li>
                            <li><a href="/terms">Terms and Conditions</a></li>
                        </ul>
                    </div>
                    <div class="footer-block footer-item">
                        <strong>Customer Service</strong>
                        <ul class="list">
                            <li><a href="/help">Help</a></li>
                            <li><a href="/shipping-info">Shipping Information</a></li>
                            <li><a href="/return-policy">Return Policy</a></li>
                        </ul>
                    </div>
                </div>

                <div class="account-newsletter">
                    <div class="footer-block footer-item">
                        <strong>My Account</strong>
                        <ul class="list">
                            <li><a href="/my-account">My Account</a></li>
                            <li><a href="/orders">Orders</a></li>
                            <li><a href="/addresses">Addresses</a></li>
                        </ul>
                    </div>
                    <div class="footer-block footer-item">
                        <strong>Newsletter</strong>
                        <form class="newsletter-form">
                            <input type="email" placeholder="Enter your email" />
                            <button type="submit">Subscribe</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

      
        <div class="footer-bottom">
            <div class="footer-disclaimer text-center">
                <span>© 2023 ShopEase - All Rights Reserved</span>
            </div>
            <div class="footer-powered text-center">
                <span>Powered by <a href="https://example.com" target="_blank" rel="noopener noreferrer">ShopEase Tech</a></span>
            </div>
        </div>
    </div>
</div>

  )
}

export default Footer