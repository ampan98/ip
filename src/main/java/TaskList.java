package main.java;

import java.util.List;
import java.util.ArrayList;

import java.io.IOException;

/**
 * Handles initialisation and maintenance of task list.
 */
public class TaskList {
    protected List<Task> tasks;
    protected Storage storage;

    TaskList() {
        this.tasks = new ArrayList<>();
        this.storage = new Storage();
    }

    public int size() {
        return this.tasks.size();
    }

    public Task get(int index) {
        return this.tasks.get(index);
    }

    /**
     * Loads task list from storage.
     *
     * @throws IOException If unable to load from file.
     */
    public void load() throws IOException {
        this.tasks = this.storage.load();
    }

    /**
     * Adds a task to list and saves list to storage.
     *
     * @param task Task to add.
     * @throws IOException If unable to save to file.
     */
    public void add(Task task) throws IOException {
        this.tasks.add(task);
        updateStorage();
    }

    /**
     * Removes and returns a task from list and saves list to storage.
     *
     * @param index Index of task to remove.
     * @return Task that was removed.
     * @throws IOException If unable to save to file.
     */
    public Task remove(int index) throws IOException {
        Task task = this.tasks.remove(index);
        updateStorage();
        return task;
    }

    /**
     * Updates task in list as done.
     *
     * @param index Index of task to update.
     * @throws IOException If unable to save to file.
     */
    public void markAsDone(int index) throws IOException {
        get(index).markAsDone();
        updateStorage();
    }

    /**
     * Updates storage with task list.
     *
     * @throws IOException If unable to save to file.
     */
    public void updateStorage() throws IOException {
        this.storage.save(tasks);
    }
}
