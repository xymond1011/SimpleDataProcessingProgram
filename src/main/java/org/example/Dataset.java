package org.example;

import java.time.LocalDate;
import java.net.URI;
import java.util.ArrayList;
import java.util.Comparator;

public class Dataset {
    private String title;
    private float usability;
    private int numOfFiles;
    private String typeOfFiles;
    private String fileSize;
    private int voteCounts;
    private String medal;
    private URI urlReference;
    private short numOfColumns;
    private int views;
    private int downloads;
    private float downloadPerView;
    private LocalDate dateCreated;
    private LocalDate lastUpdate;

    //Constructor
    public Dataset() {
        title = "";
        usability = 0.0f;
        numOfFiles = 0;
        typeOfFiles = "";
        fileSize = "0 KB";
        voteCounts = 0;
        medal = "";
        urlReference = URI.create("");
        numOfColumns = 0;
        views = 0;
        downloads = 0;
        downloadPerView = 0.0f;
        dateCreated = LocalDate.now();
        lastUpdate = LocalDate.now();
    }

    public Dataset(
            String title,
            float usability,
            int numOfFiles,
            String typeOfFiles,
            String fileSize,
            int voteCounts,
            String medal,
            URI urlReference,
            short numOfColumns,
            int views,
            int downloads,
            float downloadPerView,
            LocalDate dateCreated,
            LocalDate lastUpdate) {
        this.title = title;
        this.usability = usability;
        this.numOfFiles = numOfFiles;
        this.typeOfFiles = typeOfFiles;
        this.fileSize = fileSize;
        this.voteCounts = voteCounts;
        this.medal = medal;
        this.urlReference = urlReference;
        this.numOfColumns = numOfColumns;
        this.views = views;
        this.downloads = downloads;
        this.downloadPerView = downloadPerView;
        this.dateCreated = dateCreated;
        this.lastUpdate = lastUpdate;
    }

    //Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setUsability(float usability) {
        this.usability = usability;
    }

    public void setNumOfFiles(int numOfFiles) {
        this.numOfFiles = numOfFiles;
    }

    public void setTypeOfFiles(String typeOfFiles) {
        this.typeOfFiles = typeOfFiles;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public void setVoteCounts(int voteCounts) {
        this.voteCounts = voteCounts;
    }

    public void setMedal(String medal) {
        this.medal = medal;
    }

    public void setUrlReference(URI urlReference) {
        this.urlReference = urlReference;
    }

    public void setNumOfColumns(short numOfColumns) {
        this.numOfColumns = numOfColumns;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public void setDownloadPerView(float downloadPerView) {
        this.downloadPerView = downloadPerView;
    }

    public void setDateCreated(LocalDate date) {
        this.dateCreated = date;
    }

    public void setLastUpdate(LocalDate date) {
        this.lastUpdate = date;
    }

    //Getters
    public String getTitle() {
        return title;
    }

    public float getUsability() {
        return usability;
    }

    public int getNumOfFiles() {
        return numOfFiles;
    }

    public String getTypeOfFiles() {
        return typeOfFiles;
    }

    public String getFileSize() {
        return fileSize;
    }

    public int getVoteCounts() {
        return voteCounts;
    }

    public String getMedal() {
        return medal;
    }

    public URI getUrlReference() {
        return urlReference;
    }

    public int getNumOfColumns() {
        return numOfColumns;
    }

    public int getViews() {
        return views;
    }

    public int getDownloads() {
        return downloads;
    }

    public float getDownloadPerView() {
        return downloadPerView;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    //Additional Operations
    /**
     * Converts Dataset to Tabular Form for Display.
     * Keywords column is not included because it's too long to display.
     * @return String representation of a Dataset table.
     */
    public String toTable(int part) {
        if (part == 1) {
            return String.format(
                    "%-50s|%-10s|%-15s|%-20s|%-15s|",
                    title,
                    usability == 0 ? "N/A":String.valueOf(usability),
                    numOfFiles == 0 ? "N/A":String.valueOf(numOfFiles),
                    typeOfFiles,
                    fileSize
            );
        } else if (part == 2) {
            return String.format(
                    "%-15s|%-15s|%-70s|%-15s|",
                    voteCounts == 0 ? "N/A":String.valueOf(voteCounts),
                    medal,
                    urlReference.toString(),
                    numOfColumns == 0 ? "N/A":String.valueOf(numOfColumns)
            );
        } else {
            return String.format(
                    "%-10s|%-15s|%-20s|%-15s|%-15s|",
                    views == 0 ? "N/A":String.valueOf(views),
                    downloads == 0 ? "N/A":String.valueOf(downloads),
                    downloadPerView == 0 ? "N/A":String.valueOf(downloadPerView),
                    dateCreated == null ? "N/A":dateCreated.toString(),
                    lastUpdate == null ? "N/A":lastUpdate.toString()
            );
        }
    }

    //Sorters
    public static Comparator<Dataset> sortByTitle = Comparator.comparing(Dataset::getTitle);
    public static Comparator<Dataset> sortByUsability = Comparator.comparing(Dataset::getUsability);
    public static Comparator<Dataset> sortByNumOfFiles = Comparator.comparing(Dataset::getNumOfFiles);
    public static Comparator<Dataset> sortByNumOfColumns = Comparator.comparing(Dataset::getNumOfColumns);
    public static Comparator<Dataset> sortByFileSize = Comparator.comparing(Dataset::getFileSize);
    public static Comparator<Dataset> sortByVoteCounts = Comparator.comparing(Dataset::getVoteCounts);
    public static Comparator<Dataset> sortByDownloads = Comparator.comparing(Dataset::getDownloads);
    public static Comparator<Dataset> sortByMedal = Comparator.comparing(Dataset::getMedal);
    public static Comparator<Dataset> sortByUrlReference = Comparator.comparing(Dataset::getUrlReference);
    public static Comparator<Dataset> sortByDateCreated = Comparator.comparing(Dataset::getDateCreated);
    public static Comparator<Dataset> sortByLastUpdate = Comparator.comparing(Dataset::getLastUpdate);
}


