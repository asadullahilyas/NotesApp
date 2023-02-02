package com.example.firstkmmapp.data.note

import com.example.firstkmmapp.database.NoteDatabase
import com.example.firstkmmapp.domain.note.Note
import com.example.firstkmmapp.domain.note.NoteDateSource
import com.example.firstkmmapp.domain.time.DateTimeUtils

class SqlDelightNoteDataSource(
    db: NoteDatabase
): NoteDateSource {

    private val queries = db.noteQueries

    override suspend fun insertNote(note: Note) {
        queries.addOrReplaceNote(
            id = note.id,
            title = note.title,
            content = note.content,
            colorHex = note.colorHex,
            created = DateTimeUtils.toEpochMillis(note.created)
        )
    }

    override suspend fun getNoteById(id: Long): Note? {
        return queries
            .getNoteById(id)
            .executeAsOneOrNull()
            ?.toNote()
    }

    override suspend fun getAllNotes(): List<Note> {
        return queries.getAllNotes().executeAsList().map { it.toNote() }
    }

    override suspend fun deleteNoteById(id: Long) {
        queries.deleteNoteById(id)
    }

    override suspend fun searchNoteByQuery(query: String): List<Note> {
        return queries.searchByQuery(query).executeAsList().map { it.toNote() }
    }
}