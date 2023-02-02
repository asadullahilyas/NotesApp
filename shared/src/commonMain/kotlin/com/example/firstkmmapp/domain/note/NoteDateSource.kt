package com.example.firstkmmapp.domain.note

interface NoteDateSource {
    suspend fun insertNote(note: Note)
    suspend fun getNoteById(id: Long): Note?
    suspend fun getAllNotes(): List<Note>
    suspend fun deleteNoteById(id: Long)
    suspend fun searchNoteByQuery(query: String): List<Note>
}