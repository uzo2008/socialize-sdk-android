/*
 * Copyright (c) 2011 Socialize Inc. 
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy 
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.socialize.entity;

import java.util.ArrayList;
import java.util.List;

import com.socialize.util.StringUtils;


/**
 * @author Jason Polites
 */
public class User extends SocializeObject {

	private String firstName;
	private String lastName;
	private String username;
	private String description;
	private String location;
	private String smallImageUri;
	private String mediumImageUri;
	private String largeImageUri;
	private Stats stats;
	private List<UserAuthData> authData;
	private String displayName;
	private String profilePicData;
	
	private boolean autoPostToFacebook = true;
	
	private boolean autoPostLikesFacebook;
	private boolean autoPostCommentsFacebook;
	private boolean shareLocation = true;
	
	public void merge(User user) {
		setFirstName(user.getFirstName());
		setLastName(user.getLastName());
		setUsername(user.getUsername());
		setLocation(user.getLocation());
		setSmallImageUri(user.getSmallImageUri());
		setMediumImageUri(user.getMediumImageUri());
		setLargeImageUri(user.getLargeImageUri());
		setStats(user.getStats());
		setAuthData(user.getAuthData());
		setProfilePicData(user.getProfilePicData());
		
		// Set to null to re-create
		displayName = null;
		
//		setAutoPostToFacebook(user.isAutoPostToFacebook()); // Don't merge this!
	}

	public String getDisplayName() {
		if(displayName == null) {
			String fname = getFirstName();
			String sname = getLastName();
			String uname = getUsername();
			if(!StringUtils.isEmpty(fname)) {
				displayName = fname;
				
				if(!StringUtils.isEmpty(sname)) {
					displayName += " " + sname;
				}
			}
			else if(!StringUtils.isEmpty(sname)) {
				displayName = sname;
			}
			else if (!StringUtils.isEmpty(uname)) {
				displayName = uname;
			}
		}
		
		return displayName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSmallImageUri() {
		return smallImageUri;
	}
	public void setSmallImageUri(String smallImageUri) {
		this.smallImageUri = smallImageUri;
	}
	public String getMediumImageUri() {
		return mediumImageUri;
	}
	public void setMediumImageUri(String mediumImageUri) {
		this.mediumImageUri = mediumImageUri;
	}
	public String getLargeImageUri() {
		return largeImageUri;
	}
	public void setLargeImageUri(String largeImageUri) {
		this.largeImageUri = largeImageUri;
	}
	public Stats getStats() {
		return stats;
	}
	public void setStats(Stats stats) {
		this.stats = stats;
	}

	/**
	 * Base64 encoded image data.
	 * @return
	 */
	public String getProfilePicData() {
		return profilePicData;
	}

	public void setProfilePicData(String profilePicData) {
		this.profilePicData = profilePicData;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public List<UserAuthData> getAuthData() {
		return authData;
	}
	
	public synchronized void addUserAuthData(UserAuthData authData) {
		if(this.authData == null) {
			this.authData = new ArrayList<UserAuthData>(5);
		}
		this.authData.add(authData);
	}

	public void setAuthData(List<UserAuthData> authData) {
		this.authData = authData;
	}

	@Deprecated
	public boolean isAutoPostToFacebook() {
		return autoPostToFacebook;
	}

	@Deprecated
	public void setAutoPostToFacebook(boolean autoPostToFacebook) {
		this.autoPostToFacebook = autoPostToFacebook;
	}

	public boolean isAutoPostLikesFacebook() {
		return autoPostLikesFacebook;
	}

	public void setAutoPostLikesFacebook(boolean autoPostLikesFacebook) {
		this.autoPostLikesFacebook = autoPostLikesFacebook;
	}

	public boolean isAutoPostCommentsFacebook() {
		return autoPostCommentsFacebook;
	}

	public void setAutoPostCommentsFacebook(boolean autoPostCommentsFacebook) {
		this.autoPostCommentsFacebook = autoPostCommentsFacebook;
	}

	public boolean isShareLocation() {
		return shareLocation;
	}

	public void setShareLocation(boolean shareLocation) {
		this.shareLocation = shareLocation;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
