/**
 * 
 */
package com.brp.entity;

/**
 * @author Bendo
 *
 */
public enum ResultEnum {

	Failure {
		public String getName() {
			return "失败";
		}

		@Override
		public Boolean isSuccess() {
			return false;
		}
	},
	Success {
		public String getName() {
			return "成功";
		}

		@Override
		public Boolean isSuccess() {
			return true;
		}
	},
	Warning {
		public String getName() {
			return "警告";
		}

		@Override
		public Boolean isSuccess() {
			return true;
		}
	};

	public abstract String getName();

	public abstract Boolean isSuccess();
}
