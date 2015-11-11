package com.skplanet.syruppay.token.domain;

/**
 * @author 임형태
 * @since 2015.10.28
 */
public class TokenHistories {
    public static final History VERSION_1_2_30 = new History("1.2.30", "G3aIW7hYmlTjag3FDc63OGLNWwvagVUU", "sktmall_s002", "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJza3RtYWxsX3MwMDIiLCJhdWQiOiJodHRwczovL3BheS5zeXJ1cC5jby5rciIsInR5cCI6Impvc2UiLCJpYXQiOjE0NDU5OTg2ODAsImV4cCI6MTQ0NTk5OTI4MCwibG9naW5JbmZvIjp7Im1jdFVzZXJJZCI6IjM5ODcxMjMxIiwiU1NPQ3JlZGVudGlhbCI6IiIsImRldmljZUlkZW50aWZpZXIiOiIifSwidXNlckluZm9NYXBwZXIiOnsibWFwcGluZ1R5cGUiOiJDSV9NQVBQRURfS0VZIiwibWFwcGluZ1ZhbHVlIjoiMzk4NzEyMzEifSwidHJhbnNhY3Rpb25JbmZvIjp7Im1jdFRyYW5zQXV0aElkIjoiMjAxNTEwMjgwMDkxNjE4IiwicGF5bWVudEluZm8iOnsicHJvZHVjdFRpdGxlIjoi66Gv642wIOu5vOu5vOuhnCDtmZTsnbTtirjsv6DtgqQgMzJnIDQw6rCRIDFCT1giLCJsYW5nIjoia28iLCJjdXJyZW5jeUNvZGUiOiJLUlciLCJwYXltZW50QW10IjoyOTAwMCwic2hpcHBpbmdBZGRyZXNzIjoiYTI6S1J8fHVua25vd258fHwiLCJpc0V4Y2hhbmdlYWJsZSI6bnVsbCwiZGVsaXZlcnlOYW1lIjoiIiwiZGVsaXZlcnlQaG9uZU51bWJlciI6IiJ9LCJwYXltZW50UmVzdHJpY3Rpb25zIjp7ImNhcmRJc3N1ZXJSZWdpb24iOiJBTExPV0VEOmtvciJ9fSwiY2hlY2tvdXRJbmZvIjp7InByb2R1Y3RQcmljZSI6MjkwMDAsInN1Ym1hbGxOYW1lIjoiWyjso7wp7KCc7J207JWM7JSo7JeU7JeQ7IqkXSIsInByb2R1Y3REZWxpdmVyeUluZm8iOnsiZGVsaXZlcnlUeXBlIjoiRlJFRSIsImRlbGl2ZXJ5TmFtZSI6IuustOujjCIsImRlZmF1bHREZWxpdmVyeUNvc3RBcHBsaWVkIjpmYWxzZSwiYWRkaXRpb25hbERlbGl2ZXJ5Q29zdEFwcGxpZWQiOmZhbHNlLCJzaGlwcGluZ0FkZHJlc3NEaXNwbGF5Ijp0cnVlfSwib2ZmZXJMaXN0IjpbeyJpZCI6ImFkZEFtdFRvdCIsInVzZXJBY3Rpb25Db2RlIjpudWxsLCJ0eXBlIjpudWxsLCJuYW1lIjoi7LaU6rCA7ZWg7J24IiwiYW1vdW50T2ZmIjoxNDUwLCJ1c2VyU2VsZWN0YWJsZSI6ZmFsc2UsIm9yZGVyQXBwbGllZCI6M31dLCJsb3lhbHR5TGlzdCI6W3siaWQiOiJ1c2VPQ0IiLCJ1c2VyQWN0aW9uQ29kZSI6IlNQQTAzMDc6U1BBMDMxMSIsIm5hbWUiOiJPS-y6kOyJrOuwsSIsInN1YnNjcmliZXJJZCI6bnVsbCwiYmFsYW5jZSI6Mjc3ODE2LCJtYXhBcHBsaWNhYmxlQW10IjoyNzc4MTYsImV4Y2x1c2l2ZUdyb3VwSWQiOiIiLCJleGNsdXNpdmVHcm91cE5hbWUiOiIiLCJpbml0aWFsQXBwbGllZEFtdCI6Mjc1NTAsIm9yZGVyQXBwbGllZCI6NCwiYWRkaXRpb25hbERpc2NvdW50Ijp7InBlcmNlbnRPZmYiOjIwLjAsIm1heEFwcGxpY2FibGVBbXQiOjMwMDB9fV0sInNoaXBwaW5nQWRkcmVzc0xpc3QiOlt7ImlkIjoiM18wMDNfMCIsIm5hbWUiOiLsoJzso7zrj4Qo7YWM7Iqk7Yq4KSIsImNvdW50cnlDb2RlIjoia3IiLCJ6aXBDb2RlIjoiNjkwNzMyIiwic3RhdGUiOm51bGwsImNpdHkiOm51bGwsIm1haW5BZGRyZXNzIjoi7KCc7KO87Yq567OE7J6Q7LmY64-EIOygnOyjvOyLnCDsnbTrj4TsnbTrj5kgICDsoJzso7zrj4TspJHshozquLDsl4XsooXtlansp4Dsm5DshLzthLAgIiwiZGV0YWlsQWRkcmVzcyI6IjEx67KI7KeAIDEx64-ZIDEwMe2YuCIsInJlY2lwaWVudE5hbWUiOiLtl4jqt5wiLCJyZWNpcGllbnRQaG9uZU51bWJlciI6IjAxMDIyODk0MzY2IiwiZGVsaXZlcnlSZXN0cmljdGlvbiI6IkZBUl9GQVJfQVdBWSIsImRlZmF1bHREZWxpdmVyeUNvc3QiOjAsImFkZGl0aW9uYWxEZWxpdmVyeUNvc3QiOjMwMDAsIm9yZGVyQXBwbGllZCI6MX0seyJpZCI6IjFfMDAyXzAiLCJuYW1lIjoi7Jqw66as7KeRIiwiY291bnRyeUNvZGUiOiJrciIsInppcENvZGUiOiIxMzc3OTgiLCJzdGF0ZSI6bnVsbCwiY2l0eSI6bnVsbCwibWFpbkFkZHJlc3MiOiLshJzsmrjtirnrs4Tsi5wg7ISc7LSI6rWsIOyeoOybkOuPmSAgIO2VnOqwleyVhO2MjO2KuCAiLCJkZXRhaWxBZGRyZXNzIjoiNuuPmSA1MDjtmLgiLCJyZWNpcGllbnROYW1lIjoi7ZeI6recIiwicmVjaXBpZW50UGhvbmVOdW1iZXIiOiIwMTA5MDIyMTE3OSIsImRlbGl2ZXJ5UmVzdHJpY3Rpb24iOiJOT1RfRkFSX0FXQVkiLCJkZWZhdWx0RGVsaXZlcnlDb3N0IjowLCJhZGRpdGlvbmFsRGVsaXZlcnlDb3N0IjowLCJvcmRlckFwcGxpZWQiOjJ9LHsiaWQiOiIyXzAwMl8wIiwibmFtZSI6Iu2FjOyKpO2KuDIiLCJjb3VudHJ5Q29kZSI6ImtyIiwiemlwQ29kZSI6IjEzNzc5OCIsInN0YXRlIjpudWxsLCJjaXR5IjpudWxsLCJtYWluQWRkcmVzcyI6IuyEnOyauO2KueuzhOyLnCDshJzstIjqtawg7J6g7JuQ64-ZICAg7ZWc6rCV7JWE7YyM7Yq4ICIsImRldGFpbEFkZHJlc3MiOiIxMeuPmSAxMTExKO2FjOyKpO2KuCkiLCJyZWNpcGllbnROYW1lIjoi7ZeI6recIiwicmVjaXBpZW50UGhvbmVOdW1iZXIiOiIwMTAyMjg5NDM2NiIsImRlbGl2ZXJ5UmVzdHJpY3Rpb24iOiJOT1RfRkFSX0FXQVkiLCJkZWZhdWx0RGVsaXZlcnlDb3N0IjowLCJhZGRpdGlvbmFsRGVsaXZlcnlDb3N0IjowLCJvcmRlckFwcGxpZWQiOjN9XSwibW9udGhseUluc3RhbGxtZW50TGlzdCI6W3siY2FyZENvZGUiOiIwMSIsImNvbmRpdGlvbnMiOlt7InBheW1lbnRBbXRSYW5nZSI6IlsxMDAwMDAtXSIsIm1vbnRobHlJbnN0YWxsbWVudEluZm8iOiJZTjE7WVkxMjtZTjI7WU4zO1lONDtZWTU7WUg2O1lONztZTjg7WU45O1lOMTA7WU4xMSJ9LHsicGF5bWVudEFtdFJhbmdlIjoiWzUwMDAwLTEwMDAwMCkiLCJtb250aGx5SW5zdGFsbG1lbnRJbmZvIjoiWU4xO1lZNTtZSDY7WVkxODtZWTI0O1lOMjtZTjM7WU40O1lONztZTjg7WU45O1lOMTA7WU4xMTtZTjEyIn0seyJwYXltZW50QW10UmFuZ2UiOiJbMC01MDAwMCkiLCJtb250aGx5SW5zdGFsbG1lbnRJbmZvIjoiWU4xIn1dfSx7ImNhcmRDb2RlIjoiMDciLCJjb25kaXRpb25zIjpbeyJwYXltZW50QW10UmFuZ2UiOiJbNTAwMDAtXSIsIm1vbnRobHlJbnN0YWxsbWVudEluZm8iOiJOTjE7Tlk1O05INjtOTjI7Tk4zO05ONDtOTjc7Tk44O05OOTtOTjEwO05OMTE7Tk4xMiJ9LHsicGF5bWVudEFtdFJhbmdlIjoiWzAtNTAwMDApIiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6Ik5OMSJ9XX0seyJjYXJkQ29kZSI6IjAyIiwiY29uZGl0aW9ucyI6W3sicGF5bWVudEFtdFJhbmdlIjoiWzAtNTAwMDApIiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6IllOMSJ9XX0seyJjYXJkQ29kZSI6IjI3IiwiY29uZGl0aW9ucyI6W3sicGF5bWVudEFtdFJhbmdlIjoiWzUwMDAwLV0iLCJtb250aGx5SW5zdGFsbG1lbnRJbmZvIjoiWU4xO1lZODtZTjI7WU4zO1lONDtZTjU7WU42O1lONztZTjk7WU4xMDtZTjExO1lOMTIifSx7InBheW1lbnRBbXRSYW5nZSI6IlswLTUwMDAwKSIsIm1vbnRobHlJbnN0YWxsbWVudEluZm8iOiJZTjEifV19LHsiY2FyZENvZGUiOiIzMSIsImNvbmRpdGlvbnMiOlt7InBheW1lbnRBbXRSYW5nZSI6IlswLTUwMDAwKSIsIm1vbnRobHlJbnN0YWxsbWVudEluZm8iOiJZTjEifV19LHsiY2FyZENvZGUiOiIxNyIsImNvbmRpdGlvbnMiOlt7InBheW1lbnRBbXRSYW5nZSI6Ils4MDAwMC1dIiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6Ik5OMTtOWTM7Tk4yO05ONDtOTjU7Tkg2O05ONztOTjg7Tk45O05OMTA7Tk4xMTtOTjEyIn0seyJwYXltZW50QW10UmFuZ2UiOiJbNjAwMDAtODAwMDApIiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6Ik5OMTtOSDY7Tk4yO05OMztOTjQ7Tk41O05ONztOTjg7Tk45O05OMTA7Tk4xMTtOTjEyIn0seyJwYXltZW50QW10UmFuZ2UiOiJbMC01MDAwMCkiLCJtb250aGx5SW5zdGFsbG1lbnRJbmZvIjoiTk4xIn1dfSx7ImNhcmRDb2RlIjoiMDYiLCJjb25kaXRpb25zIjpbeyJwYXltZW50QW10UmFuZ2UiOiJbMC01MDAwMCkiLCJtb250aGx5SW5zdGFsbG1lbnRJbmZvIjoiTk4xIn1dfSx7ImNhcmRDb2RlIjoiMzYiLCJjb25kaXRpb25zIjpbeyJwYXltZW50QW10UmFuZ2UiOiJbMC01MDAwMCkiLCJtb250aGx5SW5zdGFsbG1lbnRJbmZvIjoiWU4xIn1dfSx7ImNhcmRDb2RlIjoiMDMiLCJjb25kaXRpb25zIjpbeyJwYXltZW50QW10UmFuZ2UiOiJbNTAwMDAtXSIsIm1vbnRobHlJbnN0YWxsbWVudEluZm8iOiJZTjE7WVkxMjtZTjI7WU4zO1lONDtZTjU7WU42O1lONztZTjg7WU45O1lOMTA7WU4xMSJ9XX0seyJjYXJkQ29kZSI6IjA0IiwiY29uZGl0aW9ucyI6W3sicGF5bWVudEFtdFJhbmdlIjoiWzAtNTAwMDApIiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6Ik5OMSJ9XX0seyJjYXJkQ29kZSI6IjE2IiwiY29uZGl0aW9ucyI6W3sicGF5bWVudEFtdFJhbmdlIjoiWzAtNTAwMDApIiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6Ik5OMSJ9XX0seyJjYXJkQ29kZSI6IjM1IiwiY29uZGl0aW9ucyI6W3sicGF5bWVudEFtdFJhbmdlIjoiWzAtNTAwMDApIiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6IllOMSJ9XX0seyJjYXJkQ29kZSI6IjExIiwiY29uZGl0aW9ucyI6W3sicGF5bWVudEFtdFJhbmdlIjoiWzAtNTAwMDApIiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6Ik5OMSJ9XX0seyJjYXJkQ29kZSI6IjA4IiwiY29uZGl0aW9ucyI6W3sicGF5bWVudEFtdFJhbmdlIjoiWzUwMDAwLV0iLCJtb250aGx5SW5zdGFsbG1lbnRJbmZvIjoiWU4xO1lZMjI7WU4yO1lOMztZTjQ7WU41O1lONjtZTjc7WU44O1lOOTtZTjEwO1lOMTE7WU4xMiJ9LHsicGF5bWVudEFtdFJhbmdlIjoiWzAtNTAwMDApIiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6IllOMSJ9XX1dfX0.5Sv1IaiURo-isYMg0JFEKYrRdVQgE-PSdIkHoqFGSVA", "RS256 Header에 대한 예외처리 필요 버전, 추후 Deprecated");
    public static final History C_SHARP_0_0_1 = new History("0.0.1", "1234567890123456", "syrup_order", "eyJhbGciOiJIUzI1NiIsImtpZCI6InN5cnVwX29yZGVyIiwidHlwIjoiSldUIn0.eyJhdWQiOiJodHRwczovL3BheS5zeXJ1cC5jby5rciIsInR5cCI6Impvc2UiLCJpc3MiOiJzeXJ1cF9vcmRlciIsImV4cCI6MTQ0NjYwNjY3NSwiaWF0IjoxNDQ2NjA2MDc1LCJqdGkiOiI1ZWVjZjFiYS05YTFhLTQwNDUtOWE4Yy03NDUzMDEzM2EyMWIiLCJuYmYiOjAsImxvZ2luSW5mbyI6eyJtY3RVc2VySWQiOiJzeXJ1cF9vcmRlcl91c2VyX2lkIiwiU1NPQ3JlZGVudGlhbCI6IlNTT19OTyIsImRldmljZUlkZW50aWZpZXIiOiIhISEhISEhISEhISEhISEhIn0sInVzZXJJbmZvTWFwcGVyIjp7Im1hcHBpbmdUeXBlIjoiQ0lfTUFQUEVEX0tFWSIsIm1hcHBpbmdWYWx1ZSI6IkNJIFZBTFVFIn0sInRyYW5zYWN0aW9uSW5mbyI6eyJtY3RUcmFuc0F1dGhJZCI6Ik9SRF8wMDAxIiwicGF5bWVudEluZm8iOnsiY2FyZEluZm9MaXN0IjpbeyJjYXJkQ29kZSI6Iuy5tOuTnOq1rOu2hCDsvZTrk5wiLCJtb250aGx5SW5zdGFsbG1lbnRJbmZvIjoi7ZWg67aA7KCV67O0LiBleC4gTk4xO05OMjtZWTM7WVk0O1lZNTtOSDYifV0sInByb2R1Y3RUaXRsZSI6IuygnO2SiOuqhSIsInByb2R1Y3RVcmxzIjpbImh0dHA6Ly9kZWFsLjExc3QuY28ua3IvcHJvZHVjdC9TZWxsZXJQcm9kdWN0RGV0YWlsLnRtYWxsP21ldGhvZD1nZXRTZWxsZXJQcm9kdWN0RGV0YWlsJnByZE5vPTExMjI4NDEzNDAiLCJodHRwOi8vZGVhbC4xMXN0LmNvLmtyL3Byb2R1Y3QvU2VsbGVyUHJvZHVjdERldGFpbC50bWFsbD9tZXRob2Q9Z2V0U2VsbGVyUHJvZHVjdERldGFpbCZwcmRObz0xMjY1NTA4NzQxIl0sImxhbmciOiJLTyIsImN1cnJlbmN5Q29kZSI6IktSVyIsInBheW1lbnRBbXQiOjUwMDAwLCJzaGlwcGluZ0FkZHJlc3MiOiJrcnwxMzctMzMyfOyEnOy0iOq1rCDsnqDsm5Drj5kg7ZWY64KY7JWE7YyM7Yq4fDHrj5kgMe2YuHzshJzsmrh8fCIsImRlbGl2ZXJ5UGhvbmVOdW1iZXIiOiIwMTAxMTExMjIyMiIsImRlbGl2ZXJ5TmFtZSI6IuuwsOyGoSDsiJjsi6DsnpAiLCJpc0V4Y2hhbmdlYWJsZSI6ZmFsc2V9LCJwYXltZW50UmVzdHJpY3Rpb25zIjp7ImNhcmRJc3N1ZXJSZWdpb24iOiJOT1RfQUxMT1dFRDpVU0EifX19.lkQkO3INk6Cfb_cEYx36QT54hBtywa5vMAxwNgF-rb0", "C# 릴리즈 초기 버전");
    public static final History BEFORE_11ST  = new History("0.0.1", "8I9G4IPPqkik05WZj0Da3bJ5t7BEmXYj", "sktmall_s004", "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJza3RtYWxsX3MwMDQiLCJhdWQiOiJodHRwczovL3BheS5zeXJ1cC5jby5rciIsInR5cCI6Impvc2UiLCJpYXQiOjE0NDcyNzMyNDIsImV4cCI6MTQ0NzI3Mzg0MiwicGF5bWVudEluZm8iOnsicHJvZHVjdFRpdGxlIjoiW-2PieydvCA17IucIOuLueydvOy2nOqzoCEgJiMzODsg7Yag7JqU7J28IOy2nOqzoCEgJiMzODsg7ISx64Ko7KeA7JetIOuLueydvCDsp4HrsLDshqEhXSDslYTsnbTtj7A1L-yVhOydtO2PsDVTL-yVhOydtO2PsDYv7JWE7J207Y-wNisv6rCV7ZmU7Jyg66asL-yVoeygleuztO2YuC_slZ7rkqTrs7TtmLgv7ZW465Oc7Y-w7LyA7J207IqkL-uplO2DiOy8gOydtOyKpC_rr7jrn6zsvIDsnbTsiqQv7ZWY7Jqw7KeVL-2MjOyKpO2FlOy8gOydtOyKpCIsImxhbmciOiJrbyIsImN1cnJlbmN5Q29kZSI6IktSVyIsInBheW1lbnRBbXQiOiI1MzIwMCIsInNoaXBwaW5nQWRkcmVzcyI6ImEyOktSfHzshJzsmrjtirnrs4Tsi5wg6rWs66Gc6rWsIOyYpOulmDLrj5kgICDrjIDsmrDtkbjrpbTsp4DsmKTslYTtjIztirggfDEwNS0xMDAyfHwiLCJpc0V4Y2hhbmdlYWJsZSI6bnVsbCwiZGVsaXZlcnlOYW1lIjoi6rO97IiZ7Z2sIiwiZGVsaXZlcnlQaG9uZU51bWJlciI6IjAxMDkxNjU4NzQzIiwiY2FyZEluZm9MaXN0IjpbeyJjYXJkQ29kZSI6IjA4IiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6IllOMTtZWTI7WVkzO1lZNDtZWTU7WVk2O1lZNztZWTg7WVk5O1lZMTA7WVkxMTtZWTEyIn0seyJjYXJkQ29kZSI6IjI3IiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6IllOMTtZWTI7WVkzO1lZNDtZWTU7WU42O1lONztZTjg7WU45O1lOMTA7WU4xMTtZTjEyIn0seyJjYXJkQ29kZSI6IjIwIiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6IllOMTtZTjI7WU4zO1lONDtZTjU7WU42O1lONztZTjg7WU45O1lOMTA7WU4xMTtZTjEyIn0seyJjYXJkQ29kZSI6IjIxIiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6IllOMTtZTjI7WU4zO1lONDtZTjU7WU42O1lONztZTjg7WU45O1lOMTA7WU4xMTtZTjEyIn0seyJjYXJkQ29kZSI6IjIyIiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6IllOMTtZTjI7WU4zO1lONDtZTjU7WU42O1lONztZTjg7WU45O1lOMTA7WU4xMTtZTjEyIn0seyJjYXJkQ29kZSI6IjMyIiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6IllOMTtZTjI7WU4zO1lONDtZTjU7WU42O1lONztZTjg7WU45O1lOMTA7WU4xMTtZTjEyIn0seyJjYXJkQ29kZSI6IjMzIiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6IllOMTtZTjI7WU4zO1lONDtZTjU7WU42O1lONztZTjg7WU45O1lOMTA7WU4xMTtZTjEyIn0seyJjYXJkQ29kZSI6IjM3IiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6IllOMTtZTjI7WU4zO1lONDtZTjU7WU42O1lONztZTjg7WU45O1lOMTA7WU4xMTtZTjEyIn0seyJjYXJkQ29kZSI6Ijk3IiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6IllOMTtZTjI7WU4zO1lONDtZTjU7WU42O1lONztZTjg7WU45O1lOMTA7WU4xMTtZTjEyIn0seyJjYXJkQ29kZSI6IjE0IiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6IllOMTtZTjI7WU4zO1lONDtZTjU7WU42O1lONztZTjg7WU45O1lOMTA7WU4xMTtZTjEyIn0seyJjYXJkQ29kZSI6IjM0IiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6IllOMTtZTjI7WU4zO1lONDtZTjU7WU42O1lONztZTjg7WU45O1lOMTA7WU4xMTtZTjEyIn0seyJjYXJkQ29kZSI6IjAyIiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6IllOMTtZWTI7WVkzO1lZNDtZWTU7WVk2O1lZNztZWTg7WVk5O1lZMTA7WVkxMTtZWTEyIn0seyJjYXJkQ29kZSI6IjAxIiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6IllOMTtZWTI7WVkzO1lZNDtZWTU7WVk2O1lZNztZWTg7WVk5O1lZMTA7WVkxMTtZWTEyIn0seyJjYXJkQ29kZSI6IjE3IiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6Ik5OMTtOWTI7TlkzO05ZNDtOWTU7Tkg2O05ONztOTjg7Tk45O05IMTA7Tk4xMTtOTjEyIn0seyJjYXJkQ29kZSI6IjA0IiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6Ik5OMTtOWTI7TlkzO05ZNDtOWTU7Tkg2O05ONztOTjg7Tk45O05IMTA7Tk4xMTtOTjEyIn0seyJjYXJkQ29kZSI6IjA3IiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6IllOMTtZWTI7WVkzO1lZNDtZWTU7WU42O1lONztZTjg7WU45O1lOMTA7WU4xMTtZTjEyIn0seyJjYXJkQ29kZSI6IjE2IiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6Ik5OMTtOWTI7TlkzO05ZNDtOWTU7Tlk2O05ZNztOWTg7Tlk5O05ZMTA7TlkxMTtOWTEyIn0seyJjYXJkQ29kZSI6IjExIiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6Ik5OMTtOWTI7TlkzO05ZNDtOWTU7Tlk2O05ZNztOWTg7Tlk5O05ZMTA7TlkxMTtOWTEyIn0seyJjYXJkQ29kZSI6IjM1IiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6IllOMTtZWTI7WVkzO1lZNDtZWTU7WU42O1lONztZTjg7WU45O1lOMTA7WU4xMTtZTjEyIn0seyJjYXJkQ29kZSI6IjA2IiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6Ik5OMTtOWTI7TlkzO05ZNDtOWTU7Tkg2O05ONztOTjg7Tk45O05IMTA7Tk4xMTtOTjEyIn0seyJjYXJkQ29kZSI6IjMxIiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6IllOMTtZWTI7WVkzO1lZNDtZWTU7WU42O1lONztZTjg7WU45O1lOMTA7WU4xMTtZTjEyIn0seyJjYXJkQ29kZSI6IjM2IiwibW9udGhseUluc3RhbGxtZW50SW5mbyI6IllOMTtZWTI7WVkzO1lZNDtZWTU7WU42O1lONztZTjg7WU45O1lOMTA7WU4xMTtZTjEyIn1dfSwicGF5bWVudFJlc3RyaWN0aW9ucyI6eyJjYXJkSXNzdWVyUmVnaW9uIjoiQUxMT1dFRDprb3IifSwibG9naW5JbmZvIjp7Im1jdFVzZXJJZCI6IjI3Mzg2NjkxIiwiU1NPQ3JlZGVudGlhbCI6InNlclBtanNXbUlCTlJJMlFTdXJ5U3FydkJiOEhvbmE4eWJhNVRxdXVqUGMifSwidHJhbnNhY3Rpb25JbmZvIjp7Im1jdFRyYW5zQXV0aElkIjoiMjAxNTExMTI2MjExNjI0In0sInVzZXJJbmZvTWFwcGVyIjp7Im1hcHBpbmdUeXBlIjoiQ0lfTUFQUEVEX0tFWSIsIm1hcHBpbmdWYWx1ZSI6IjI3Mzg2NjkxIn19._9J4nh7Q5bK-5-A3XtrYTqlCDsT3Myi3rwVfKHlNzgU", "라이브러리 적용되지 전 버전 토큰");
    public static final History[] ALL = {
            VERSION_1_2_30, C_SHARP_0_0_1, BEFORE_11ST

    };

    public static class History {
        public final String version;
        public final String key;
        public final String iss;
        public final String token;
        public final String contents;

        public History(String version, String key, String iss, String token, String contents) {
            this.version = version;
            this.key = key;
            this.iss = iss;
            this.token = token;
            this.contents = contents;
        }
    }
}
