> This documentation is generated by [JApiDocs](https://japidocs.agilestudio.cn/).
---
# 图书接口
## 图书列表

*作者: yeguozhong yedaxia.github.com*

**请求URL**

/api/book/list `GET` 

**请求参数**

参数名|类型|必须|描述
--:|:--:|:--:|:--
page|int|否|页数
limit|int|否|每页条数
sort|string|否|排序

**返回结果**

```json
{
	"body":{
		"total":"int //总记录数",
		"pageCount":"int //页数",
		"currentPage":"int //当前页",
		"pageSize":"int //每页记录数",
		"list":[{
			"bookId":"long //图书id",
			"bookName":"string //图书名称",
			"price":{
				"price":"double //价格",
				"country":"int //国家"
			}
		}],
		"hasMore":"boolean //是否还有更多"
	},
	"code":"int",
	"errMsg":"string",
	"data":{
		"total":"int //总记录数",
		"pageCount":"int //页数",
		"currentPage":"int //当前页",
		"pageSize":"int //每页记录数",
		"list":[{
			"bookId":"long //图书id",
			"bookName":"string //图书名称",
			"price":{
				"price":"double //价格",
				"country":"int //国家"
			}
		}],
		"hasMore":"boolean //是否还有更多"
	},
	"errType":"enum // [SUCCESS,WARN,ERROR]"
}
```
## 图书详情

*作者: yeguozhong yedaxia.github.com*

**请求URL**

/api/book/book-detail `GET` 

**请求参数**

参数名|类型|必须|描述
--:|:--:|:--:|:--
id|long|是|图书ID

**返回结果**

```json
{
	"body":{
		"bookId":"long //图书id",
		"bookName":"string //图书名称",
		"price":{
			"price":"double //价格",
			"country":"int //国家"
		},
		"storeCount":"int //馆藏数量",
		"pictures":"string[] //图片",
		"owner":{
			"userId":"string //用户id",
			"userName":"string //用户名",
			"friend":"SimpleUser{}",
			"friends":[{
				"userId":"string //用户id",
				"userName":"string //用户名",
				"friend":"SimpleUser{}"
			}],
			"readBooks":[{
				"bookId":"long //图书id",
				"bookName":"string //图书名称",
				"price":{
					"price":"double //价格",
					"country":"int //国家"
				}
			}],
			"isFollow":"boolean //是否关注",
			"follower":"UserVO[]"
		}
	},
	"code":"int",
	"errMsg":"string",
	"data":{
		"bookId":"long //图书id",
		"bookName":"string //图书名称",
		"price":{
			"price":"double //价格",
			"country":"int //国家"
		},
		"storeCount":"int //馆藏数量",
		"pictures":"string[] //图片",
		"owner":{
			"userId":"string //用户id",
			"userName":"string //用户名",
			"friend":"SimpleUser{}",
			"friends":[{
				"userId":"string //用户id",
				"userName":"string //用户名",
				"friend":"SimpleUser{}"
			}],
			"readBooks":[{
				"bookId":"long //图书id",
				"bookName":"string //图书名称",
				"price":{
					"price":"double //价格",
					"country":"int //国家"
				}
			}],
			"isFollow":"boolean //是否关注",
			"follower":"UserVO[]"
		}
	},
	"errType":"enum // [SUCCESS,WARN,ERROR]"
}
```
## 删除图书

*作者: yeguozhong yedaxia.github.com*

**请求URL**

/api/book/del-book `GET` 

**请求参数**

参数名|类型|必须|描述
--:|:--:|:--:|:--
bookId|long|是|图书ID

**返回结果**

```json
{
	"body":{
		"bookId":"long //图书id",
		"bookName":"string //图书名称",
		"price":{
			"price":"double //价格",
			"country":"int //国家"
		}
	},
	"code":"int",
	"errMsg":"string",
	"data":{
		"bookId":"long //图书id",
		"bookName":"string //图书名称",
		"price":{
			"price":"double //价格",
			"country":"int //国家"
		}
	},
	"errType":"enum // [SUCCESS,WARN,ERROR]"
}
```
## 批量删除图书

*作者: yeguozhong yedaxia.github.com*

**请求URL**

/api/book/del-books `DELETE` 

**请求参数**

参数名|类型|必须|描述
--:|:--:|:--:|:--
bookIds|long[]|否|

**返回结果**

```json
{
	"body":{},
	"code":"int",
	"errMsg":"string",
	"data":{},
	"errType":"enum // [SUCCESS,WARN,ERROR]"
}
```
## 购买图书

*作者: yeguozhong yedaxia.github.com*

**请求URL**

/api/book/buy-book `POST` 

**请求参数**

参数名|类型|必须|描述
--:|:--:|:--:|:--
bookId|long|否|

**返回结果**

```json
{
	"headers":{
		"headers":{}
	},
	"body":{
		"bookId":"long",
		"bookName":"string",
		"price":{
			"price":"double",
			"country":"int"
		}
	}
}
```
# 用户接口
## 用户列表

*作者: yedaxia*

**请求URL**

/api/user/list `GET` `POST` 

**请求参数**

参数名|类型|必须|描述
--:|:--:|:--:|:--
page|int|否|页数
limit|int|否|每页条数
sort|string|否|排序
status|int|否|用户状态
name|string|是|用户名

**返回结果**

```json
{
	"body":{
		"total":"int //总记录数",
		"pageCount":"int //页数",
		"currentPage":"int //当前页",
		"pageSize":"int //每页记录数",
		"list":[{
			"userId":"string //用户id",
			"userName":"string //用户名",
			"friend":"SimpleUser{}",
			"friends":[{
				"userId":"string //用户id",
				"userName":"string //用户名",
				"friend":"SimpleUser{}"
			}],
			"readBooks":[{
				"bookId":"long //图书id",
				"bookName":"string //图书名称",
				"price":{
					"price":"double //价格",
					"country":"int //国家"
				}
			}],
			"isFollow":"boolean //是否关注",
			"follower":"UserVO[]"
		}],
		"hasMore":"boolean //是否还有更多"
	},
	"code":"int",
	"errMsg":"string",
	"data":{
		"total":"int //总记录数",
		"pageCount":"int //页数",
		"currentPage":"int //当前页",
		"pageSize":"int //每页记录数",
		"list":[{
			"userId":"string //用户id",
			"userName":"string //用户名",
			"friend":"SimpleUser{}",
			"friends":[{
				"userId":"string //用户id",
				"userName":"string //用户名",
				"friend":"SimpleUser{}"
			}],
			"readBooks":[{
				"bookId":"long //图书id",
				"bookName":"string //图书名称",
				"price":{
					"price":"double //价格",
					"country":"int //国家"
				}
			}],
			"isFollow":"boolean //是否关注",
			"follower":"UserVO[]"
		}],
		"hasMore":"boolean //是否还有更多"
	},
	"errType":"enum // [SUCCESS,WARN,ERROR]"
}
```
## 用户信息

*作者: 周杰伦*

**请求URL**

/api/user/user-info/{userId} `GET` 

**请求参数**

参数名|类型|必须|描述
--:|:--:|:--:|:--
userId|long|是|用户id
**请求体**

```json
{
	"id":"long //用户ID",
	"name":"string //用户名【必须】",
	"phone":"long //电话【必须】",
	"avatar":"string //头像【必须】",
	"gender":"byte //性别"
}
```

**返回结果**

```json
{
	"body":{
		"userId":"string //用户id",
		"userName":"string //用户名",
		"friend":"SimpleUser{}",
		"friends":[{
			"userId":"string //用户id",
			"userName":"string //用户名",
			"friend":"SimpleUser{}"
		}],
		"readBooks":[{
			"bookId":"long //图书id",
			"bookName":"string //图书名称",
			"price":{
				"price":"double //价格",
				"country":"int //国家"
			}
		}],
		"isFollow":"boolean //是否关注",
		"follower":"UserVO[]"
	},
	"code":"int",
	"errMsg":"string",
	"data":{
		"userId":"string //用户id",
		"userName":"string //用户名",
		"friend":"SimpleUser{}",
		"friends":[{
			"userId":"string //用户id",
			"userName":"string //用户名",
			"friend":"SimpleUser{}"
		}],
		"readBooks":[{
			"bookId":"long //图书id",
			"bookName":"string //图书名称",
			"price":{
				"price":"double //价格",
				"country":"int //国家"
			}
		}],
		"isFollow":"boolean //是否关注",
		"follower":"UserVO[]"
	},
	"errType":"enum // [SUCCESS,WARN,ERROR]"
}
```
## 保存用户

*作者: yeguozhong*

**请求URL**

/api/user/save `POST` 

**请求体**

```json
{
	"id":"long //用户ID",
	"name":"string //用户名【必须】",
	"phone":"long //电话【必须】",
	"avatar":"string //头像【必须】",
	"gender":"byte //性别"
}
```

**返回结果**

```json
{
	"body":{
		"userId":"string //用户id",
		"userName":"string //用户名",
		"friend":"SimpleUser{}",
		"friends":[{
			"userId":"string //用户id",
			"userName":"string //用户名",
			"friend":"SimpleUser{}"
		}],
		"readBooks":[{
			"bookId":"long //图书id",
			"bookName":"string //图书名称",
			"price":{
				"price":"double //价格",
				"country":"int //国家"
			}
		}],
		"isFollow":"boolean //是否关注",
		"follower":"UserVO[]"
	},
	"code":"int",
	"errMsg":"string",
	"data":{
		"userId":"string //用户id",
		"userName":"string //用户名",
		"friend":"SimpleUser{}",
		"friends":[{
			"userId":"string //用户id",
			"userName":"string //用户名",
			"friend":"SimpleUser{}"
		}],
		"readBooks":[{
			"bookId":"long //图书id",
			"bookName":"string //图书名称",
			"price":{
				"price":"double //价格",
				"country":"int //国家"
			}
		}],
		"isFollow":"boolean //是否关注",
		"follower":"UserVO[]"
	},
	"errType":"enum // [SUCCESS,WARN,ERROR]"
}
```
## 上传头像

*作者: yeguozhong*

**请求URL**

/api/user/upload-avatar `POST` 

**请求参数**

参数名|类型|必须|描述
--:|:--:|:--:|:--
avatar|file|否|

**返回结果**

```json
{
	"body":{},
	"code":"int",
	"errMsg":"string",
	"data":{},
	"errType":"enum // [SUCCESS,WARN,ERROR]"
}
```
## 修改用户信息

*作者: yeguozhong*

**请求URL**

/api/user/modify `POST` 

**请求参数**

参数名|类型|必须|描述
--:|:--:|:--:|:--
id|long|否|用户ID
name|string|是|用户名
phone|long|是|电话
avatar|string|是|头像
gender|byte|否|性别

**返回结果**

```json
{
	"body":{
		"userId":"string //用户id",
		"userName":"string //用户名",
		"friend":"SimpleUser{}",
		"friends":[{
			"userId":"string //用户id",
			"userName":"string //用户名",
			"friend":"SimpleUser{}"
		}],
		"readBooks":[{
			"bookId":"long //图书id",
			"bookName":"string //图书名称",
			"price":{
				"price":"double //价格",
				"country":"int //国家"
			}
		}],
		"isFollow":"boolean //是否关注",
		"follower":"UserVO[]"
	},
	"code":"int",
	"errMsg":"string",
	"data":{
		"userId":"string //用户id",
		"userName":"string //用户名",
		"friend":"SimpleUser{}",
		"friends":[{
			"userId":"string //用户id",
			"userName":"string //用户名",
			"friend":"SimpleUser{}"
		}],
		"readBooks":[{
			"bookId":"long //图书id",
			"bookName":"string //图书名称",
			"price":{
				"price":"double //价格",
				"country":"int //国家"
			}
		}],
		"isFollow":"boolean //是否关注",
		"follower":"UserVO[]"
	},
	"errType":"enum // [SUCCESS,WARN,ERROR]"
}
```
## 删除用户

*作者: yeguozhong*

**请求URL**

/api/user/delete `POST` 

**请求参数**

参数名|类型|必须|描述
--:|:--:|:--:|:--
userId|long|是|用户ID

**返回结果**

```json
{
	"body":{},
	"code":"int",
	"errMsg":"string",
	"data":{},
	"errType":"enum // [SUCCESS,WARN,ERROR]"
}
```
## 获取图片

*作者: yeguozhong*

**请求URL**

/api/user/get-image `GET` 


**返回结果**

```json
{}
```
## 用户列表2

*作者: yeguozhong*

**请求URL**

/api/user/list2 `GET` 

**请求参数**

参数名|类型|必须|描述
--:|:--:|:--:|:--
userId|long|是|用户ID
**请求体**

```json
{
	"id":"long //用户ID",
	"name":"string //用户名【必须】",
	"phone":"long //电话【必须】",
	"avatar":"string //头像【必须】",
	"gender":"byte //性别"
}
```

**返回结果**

```json
{
	"body":[{
		"userId":"string //用户id",
		"userName":"string //用户名",
		"friend":"SimpleUser{}",
		"friends":[{
			"userId":"string //用户id",
			"userName":"string //用户名",
			"friend":"SimpleUser{}"
		}],
		"readBooks":[{
			"bookId":"long //图书id",
			"bookName":"string //图书名称",
			"price":{
				"price":"double //价格",
				"country":"int //国家"
			}
		}],
		"isFollow":"boolean //是否关注",
		"follower":"UserVO[]"
	}],
	"code":"int",
	"errMsg":"string",
	"data":[{
		"userId":"string //用户id",
		"userName":"string //用户名",
		"friend":"SimpleUser{}",
		"friends":[{
			"userId":"string //用户id",
			"userName":"string //用户名",
			"friend":"SimpleUser{}"
		}],
		"readBooks":[{
			"bookId":"long //图书id",
			"bookName":"string //图书名称",
			"price":{
				"price":"double //价格",
				"country":"int //国家"
			}
		}],
		"isFollow":"boolean //是否关注",
		"follower":"UserVO[]"
	}],
	"errType":"enum // [SUCCESS,WARN,ERROR]"
}
```
## 用户列表3

*作者: yeguozhong*

**请求URL**

/api/user/list3 `GET` 

**请求参数**

参数名|类型|必须|描述
--:|:--:|:--:|:--
page|int|否|页数
limit|int|否|每页条数
sort|string|否|排序

**返回结果**

```json
[{
	"userId":"string //用户id",
	"userName":"string //用户名",
	"friend":"SimpleUser{}",
	"friends":[{
		"userId":"string //用户id",
		"userName":"string //用户名",
		"friend":"SimpleUser{}"
	}],
	"readBooks":[{
		"bookId":"long //图书id",
		"bookName":"string //图书名称",
		"price":{
			"price":"double //价格",
			"country":"int //国家"
		}
	}],
	"isFollow":"boolean //是否关注",
	"follower":"UserVO[]"
}]
```
## List测试

*作者: yeguozhong*

**请求URL**

/api/user/list-by-ids `GET` 

**请求参数**

参数名|类型|必须|描述
--:|:--:|:--:|:--
ids|long[]|否|用户id

**返回结果**

```json
{
	"body":{},
	"code":"int",
	"errMsg":"string",
	"data":{},
	"errType":"enum // [SUCCESS,WARN,ERROR]"
}
```
## 枚举参数测试

*作者: yeguozhong*

**请求URL**

/api/user/getByUserType `GET` 

**请求参数**

参数名|类型|必须|描述
--:|:--:|:--:|:--
userType|enum|否|

**返回结果**

```json
{
	"body":{},
	"code":"int",
	"errMsg":"string",
	"data":{},
	"errType":"enum // [SUCCESS,WARN,ERROR]"
}
```
## 字符串结果

*作者: yeguozhong*

**请求URL**

/api/user/custom-json `GET` 


**返回结果**

```json
{
	"code":0,
	"data":"success"
}
```
## 泛型参数

*作者: yeguozhong*

**请求URL**

/api/user/generic-form `GET` 

**请求体**

```json
{
	"form":{
		"id":"long //用户ID",
		"name":"string //用户名【必须】",
		"phone":"long //电话【必须】",
		"avatar":"string //头像【必须】",
		"gender":"byte //性别"
	}
}
```

**返回结果**

```json
{
	"body":{},
	"code":"int",
	"errMsg":"string",
	"data":{},
	"errType":"enum // [SUCCESS,WARN,ERROR]"
}
```
# 管理员接口
## 管理员登录

*作者: yeguozhong yedaxia.github.com*

**请求URL**

/api/v1/admin/login `post` `GET` 

**请求参数**

参数名|类型|必须|描述
--:|:--:|:--:|:--
name|string|是|登录名
password|string|是|密码

**返回结果**

```json
{
	"userId":"string //用户id",
	"userName":"string //用户名",
	"friend":"SimpleUser{}",
	"password":"string //密码"
}
```
## ~~邮箱登录~~

*作者: yeguozhong yedaxia.github.com*

**请求URL**

/api/v1/admin/emailLogin `POST` 

**请求参数**

参数名|类型|必须|描述
--:|:--:|:--:|:--
email|string|是|
password|string|否|

**返回结果**

```json
{
	"userId":"string //用户id",
	"userName":"string //用户名",
	"friend":"SimpleUser{}",
	"password":"string //密码"
}
```
## 添加管理员

*作者: yeguozhong yedaxia.github.com*

**请求URL**

/api/v1/admin/add `POST` 

**请求体**

```json
{
	"name":"string //名字",
	"password":"string //密码"
}
```

**返回结果**

```json
{
	"userId":"string //用户id",
	"userName":"string //用户名",
	"friend":"SimpleUser{}",
	"password":"string //密码"
}
```
## 添加多个管理员

*作者: yeguozhong yedaxia.github.com*

**请求URL**

/api/v1/admin/addMany `POST` 

**请求体**

```json
[{
	"name":"string //名字",
	"password":"string //密码"
}]
```

**返回结果**

```json
[{
	"userId":"string //用户id",
	"userName":"string //用户名",
	"friend":"SimpleUser{}",
	"password":"string //密码"
}]
```
## 测试map

*作者: yeguozhong yedaxia.github.com*

**请求URL**

/test-map `GET` `POST` 


**返回结果**

```json
Map{}
```
