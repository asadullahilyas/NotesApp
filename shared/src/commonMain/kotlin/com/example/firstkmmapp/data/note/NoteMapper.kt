package com.example.firstkmmapp.data.note

import com.example.firstkmmapp.domain.note.Note
import database.NoteEntity
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun NoteEntity.toNote() = Note(
    this.id,
    this.title,
    this.content,
    this.colorHex,
    Instant.fromEpochMilliseconds(this.created).toLocalDateTime(TimeZone.currentSystemDefault())
)