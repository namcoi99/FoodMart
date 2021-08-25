import { faSearch, faShoppingBag } from '@fortawesome/free-solid-svg-icons';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { Category } from '../category';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  categories: Category[] = [
    { id: 1, name: "Produce" },
    { id: 2, name: "Dairy, Milk & Eggs" },
    { id: 3, name: "Meat & Seafood" },
    { id: 4, name: "Vegetables" },
    { id: 5, name: "Frozen Foods" },
    { id: 6, name: "Snack & Lunch Ideas" },
    { id: 7, name: "Breakfast & Cereal" },
    { id: 8, name: "Candy" },
  ];

  products: Product[] | undefined;
  faShoppingBag = faShoppingBag;
  faSearch = faSearch;

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.getProducts();
  }

  public getProducts(): void {
    this.productService.getProducts().subscribe(
      (response: Product[]) => {
        this.products = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        this.products = []
      }
    )
  }

  public searchProducts(key: string): void {
    var results: Product[] | undefined = this.products?.filter(product => product.name.toLowerCase().includes(key.toLowerCase()));
    this.products = results;
    if (!key) {
      this.getProducts();
    }
  }

  public filterProducts(categories: string[]): void {

  }

}
