package teamhardcoder.y_fi.database.data;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAutoGeneratedKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

/**
 * Created by Andrew on 2/13/17.
 */

@DynamoDBTable(tableName = "GROUP")
public class Group  {

    private String groupId; // Autogenerated when creating object
    private String createdDate; // Autogenerated when creating object
    private String groupName;
    private Set<String> userIdSet;

    public Group() {
        Calendar cur_cal = Calendar.getInstance();
        Date dt = cur_cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        //dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        createdDate = dateFormat.format(dt);
    }

    public Group(String groupName,  Set<String> userIdSet){
        this();
        this.groupName = groupName;
        this.userIdSet = userIdSet;
    }

    @DynamoDBHashKey(attributeName = "groupId")
    @DynamoDBAutoGeneratedKey
    public String getGroupId() {
        return groupId;
    }

    /*
     * DON'T CALL THIS METHOD
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @DynamoDBAttribute(attributeName = "groupName")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @DynamoDBAttribute(attributeName = "createdDate")
    public String getCreatedDate() {
        return createdDate;
    }

    /*
     * DON'T CALL THIS METHOD
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @DynamoDBAttribute(attributeName = "userIdSet")
    public Set<String> getUserIdSet() {
        return userIdSet;
    }
    public void setUserIdSet(Set<String> userIdSet) {
        this.userIdSet = userIdSet;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", createdDate=" + createdDate +
                ", groupName=" + groupName +
                ", userIdSet{" + userIdSet +
                "}";
    }
}
