package com.clrvynt.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USER_ATTACHMENTS")
public class UserAttachment implements Serializable {

    private static final long serialVersionUID = -6964321536573207749L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attachment_seq")
    @SequenceGenerator(name = "attachment_seq", sequenceName = "USER_ATTACHMENTS_ATTACHMENT_ID_SEQ")
    @Column(name = "ATTACHMENT_ID")
    private Integer id;

    @Column(name = "ATTACHMENT_BYTES")
    @JsonIgnore
    private byte[] attachmentBytes;
    @Column(name = "CONTENT_TYPE")
    private String contentType;

    public UserAttachment() {
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public byte[] getAttachmentBytes() {
	return attachmentBytes;
    }

    public void setAttachmentBytes(byte[] attachmentBytes) {
	this.attachmentBytes = attachmentBytes;
    }

    public String getContentType() {
	return contentType;
    }

    public void setContentType(String contentType) {
	this.contentType = contentType;
    }

    @Override
    public String toString() {
	return "Attachment [id=" + id + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof UserAttachment))
	    return false;
	UserAttachment other = (UserAttachment) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }
}
