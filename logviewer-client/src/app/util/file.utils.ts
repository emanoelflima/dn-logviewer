/**
 * Utility for file manipulation
 * @author Emanoel de Lima
 */
export class FileUtils {

    /**
     * Prompts a file to be downloaded
     * @param data data to be transformed into a file
     * @param filename name of the file, with extension
     * @param fileType file mime type
     */
    public static downloadFromString(data: string, filename: string, fileType: string) {
        var blob = new Blob([data], { type: fileType })
        var a = document.createElement("a");
        a.href = URL.createObjectURL(blob);
        a.download = filename;
        a.click();
    }
}
