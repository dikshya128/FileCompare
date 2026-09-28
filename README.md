# FileCompare

A Java command-line tool that compares text and files and reports the differences between them. It supports plain text, CSV, PDF, and Excel (.xls) inputs, so the same tool can be used to check expected versus actual output across common file formats.

## Features

- Text and TXT comparison: compares two strings or two .txt files
- CSV comparison: compare two csv files
- PDF comparison: extract text from two PDFs and compare the content
- Excel comparison: read and compare .xls files

## Technologies

- Java
- Java File I/O
- CSV, PDF, and Excel processing using OpenCSV, Apache POI, Apache PDFBox

## Run

Clone the repository and run `Main.java`:

```bash
git clone https://github.com/dikshya128/FileCompare.git
