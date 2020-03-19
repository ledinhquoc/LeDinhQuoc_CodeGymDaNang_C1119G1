import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})
export class PetComponent implements OnInit {
  petName = 'puppie';
  petImage = 'https://i.pinimg.com/originals/09/df/f2/09dff222d763d10bebcde24c519bae81.jpg';


  constructor() { }

  updateName(name){
    this.petName = name;
  }

  updateImage(image){
    this.petImage = image;
  }

  ngOnInit(): void {
  }

}
