import { Rendering } from "./rendering.model";
import { Summary } from "./summary.model";

/**
 * Class representing the report data
 * @author Emanoel de Lima
 */
export class Report {
    rendering: Rendering[] = [];
    summary: Summary = new Summary();
}