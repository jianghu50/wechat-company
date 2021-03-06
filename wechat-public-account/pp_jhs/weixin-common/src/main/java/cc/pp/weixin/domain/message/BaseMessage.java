package cc.pp.weixin.domain.message;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

import cc.pp.weixin.constant.MsgFieldName;


/**
 * 微信公众平台消息基类
 * @author wgybzb
 * @since  2013-04-06
 */
public class BaseMessage implements Serializable{

	/**
	 * 默认的序列化版本号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 发送方帐号（一个OpenID）
	 */
	protected String fromUserName;
	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	/**
	 * 开发者微信号
	 */
	protected String toUserName;
	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	/**
	 * 消息创建时间 （整型）
	 */
	protected long createTime;
	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	/**
	 * 消息类型
	 */
	protected String msgType;
	public String getMsgType() {
		return msgType;
	}

	/**
	 * 默认构造函数
	 */
	public BaseMessage() {

	}

	/**
	 * 构造函数：根据微信平台的请求数据，封装消息通用属性
	 */
	public BaseMessage(Element element) {
		if (element == null){
			return;
		}
		this.toUserName = element.elementText(MsgFieldName.TO_USER_NAME);
		this.fromUserName = element.elementText(MsgFieldName.FROM_USER_NAME);
		this.msgType = element.elementText(MsgFieldName.MSG_TYPE);

		String createTimeStr = element.elementText(MsgFieldName.CREATE_TIME);
		if (StringUtils.isNotEmpty(createTimeStr) && StringUtils.isNumeric(createTimeStr)){
			this.createTime = Long.valueOf(createTimeStr);
		}
	}
}
