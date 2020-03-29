import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

interface ITodo {
  id: number;
  content: string;
  complete: boolean;
}
let _id = 1;
@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss']
})
export class TodoComponent implements OnInit {
  userInput = new FormControl();
  todos: Array<ITodo> = [];
  constructor() { }

  ngOnInit() {
  }

  onChange(input) {
    // const {value} = this.userInput;
    const value=input.value;
    if (value) {
      const todo: ITodo = {
        id: _id++,
        content: value,
        complete: false
      };
      this.todos.push(todo);
input.value="";
    }
  }

  toggleTodo(i) {
    this.todos[i].complete = !this.todos[i].complete;

  }
}