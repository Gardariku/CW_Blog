package api;

import server.Entry;

import java.util.List;

public interface EntriesService {
    List<Entry> ShowEntries(String category);
    List<Entry> ShowEntries(int ID);
    boolean AddEntry(Entry entry);
}
