import { Component, OnInit } from '@angular/core';
import { faUser, faShoppingCart, faHeart, faChevronDown } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Food Mart';
  faUser = faUser;
  faShoppingCart = faShoppingCart;
  faHeart = faHeart;
  faChevronDown = faChevronDown;
}
