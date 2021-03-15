import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Report } from './model/report.model';
import { ReportService } from './service/report-service.service';
import * as xml2js from 'xml2js';
import 'rxjs';
import { Summary } from './model/summary.model';
import { FileUtils } from './util/file.utils';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
/**
 * Controller of the application.
 * @author Emanoel de Lima
 */
export class AppComponent {

  title = 'DN LogViewer';
  files: File[] = [];
  loadingData: boolean = false;
  successLoadingData: boolean = false;
  
  report: Report = new Report();
  reportXml: string = "";

  displayedColumns: string[] = ['documentId', 'gets', 'pageNumber', 'starts', 'uid'];

  private durationInSeconds = 5;

  constructor(private _snackBar: MatSnackBar, private _reportService: ReportService) {}

  public onSelectFile(event: any){
    this.files = event.files;
  }

  public processFile() {
    if(this.files.length > 0) {
      this.loadingData = true;
      this._reportService.generateReport(this.files[0]).subscribe(resp => {
        this.reportXml = resp;
        xml2js.parseStringPromise(resp).then(result => {
          this.assignReport(result);
        }).catch(error => {
          this.openSnackBar('Sorry, something went wrong while parsing xml... :(');
        });
      }, err => {
        this.loadingData = false;
        this.openSnackBar('Sorry, something went wrong... :(');
      });
      
    }
    else {
      this.openSnackBar('No file selected.');
    }
  }

  public downloadXml() {
    FileUtils.downloadFromString(this.reportXml, "report.xml", 'text/plain');
  }

  public closeSuccess() {
    this.successLoadingData = false;
  }

  private openSnackBar(message: string) {
    this._snackBar.open(message, "Close", { duration: this.durationInSeconds * 1000});
  }

  private assignReport(result: any) {
    this.report = result.report;
    this.loadingData = false;
    this.successLoadingData = true;
    this.sanitizeSummary();
  }

  private sanitizeSummary() {
    let s = new Summary();
    s.count = (<any> this.report.summary)[0].count[0];
    s.duplicates = (<any> this.report.summary)[0].duplicates[0];
    s.unecessary = (<any> this.report.summary)[0].unecessary[0];
    this.report.summary = s;
  }

}
