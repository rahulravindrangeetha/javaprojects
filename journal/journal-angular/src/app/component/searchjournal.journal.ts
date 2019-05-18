import {Component}  from '@angular/core';

@Component({
    selector:'journal-search',
    templateUrl:'../html/search.journal.html',
    styleUrls:['../app.component.css']
})
export class SearchJournal     
{
  title = 'Search Journal';
  tags :String[];
}

