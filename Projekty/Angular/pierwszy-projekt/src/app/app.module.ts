import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';  // Upewnij się, że ścieżka jest poprawna

@NgModule({
  declarations: [
    // Usuń deklarację AppComponent z tego miejsca
  ],
  imports: [
    BrowserModule,
  ],
  bootstrap: [AppComponent],  // Tu pozostaw tylko bootstrap z AppComponent
})
export class AppModule {}
