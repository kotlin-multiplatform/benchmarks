package kmp.benchmarks.serialization.model.gson

import com.google.gson.annotations.SerializedName

sealed interface GithubPush {
    data class Normal(
        val id: String,
        val type: String,
        val actor: Actor,
        val repo: Repo.Simple,
        val payload: Payload,
        val public: Boolean,
        @SerializedName("created_at") val createdAt: String,
        val org: Org? = null
    ) {
        data class Actor(
            val id: Int,
            val login: String,
            @SerializedName("gravatar_id") val gravatarId: String,
            val url: String,
            @SerializedName("avatar_url") val avatarUrl: String
        )

        data class Payload(
            @SerializedName("push_id") val pushId: Int? = null,
            val size: Int? = null,
            @SerializedName("distinct_size") val distinctSize: Int? = null,
            val ref: String? = null,
            val head: String? = null,
            val before: String? = null,
            val commits: List<Commit>? = null,
            @SerializedName("ref_type") val refType: String? = null,
            @SerializedName("master_branch") val masterBranch: String? = null,
            val description: String? = null,
            @SerializedName("pusher_type") val pusherType: String? = null,
            val action: String? = null,
            val release: Release? = null,
            val number: Int? = null,
            @SerializedName("pull_request") val pullRequest: PullRequest.Full? = null,
            val issue: Issue? = null,
            val public: Boolean? = null,
            @SerializedName("created_at") val createdAt: String? = null,
            val forkee: Repo.Full? = null,
            val pages: List<Page>? = null,
            val comment: Comment? = null,
            val member: User? = null
        )

        data class Commit(
            val sha: String,
            val author: Author,
            val message: String,
            val distinct: Boolean,
            val url: String
        ) {
            data class Author(
                val email: String,
                val name: String
            )
        }

        data class Release(
            val url: String,
            @SerializedName("assets_url") val assetsUrl: String,
            @SerializedName("upload_url") val uploadUrl: String,
            @SerializedName("html_url") val htmlUrl: String,
            val id: Int,
            @SerializedName("tag_name") val tagName: String,
            @SerializedName("target_commitish") val targetCommitish: String,
            val name: String? = null,
            val draft: Boolean,
            val author: User,
            val prerelease: Boolean,
            @SerializedName("created_at") val createdAt: String,
            @SerializedName("published_at") val publishedAt: String,
            val assets: List<Asset>,
            @SerializedName("tarball_url") val tarballUrl: String,
            @SerializedName("zipball_url") val zipballUrl: String,
            val body: String? = null
        ) {
            data class Asset(
                val url: String,
                val id: Int,
                val name: String,
                val label: String? = null,
                val uploader: User,
                @SerializedName("content_type") val contentType: String,
                val state: String,
                val size: Int,
                @SerializedName("download_count") val downloadCount: Int,
                @SerializedName("created_at") val createdAt: String,
                @SerializedName("updated_at") val updatedAt: String,
                @SerializedName("browser_download_url") val browserDownloadUrl: String
            )
        }

        data class Issue(
            val url: String,
            @SerializedName("labels_url") val labelsUrl: String,
            @SerializedName("comments_url") val commentsUrl: String,
            @SerializedName("events_url") val eventsUrl: String,
            @SerializedName("html_url") val htmlUrl: String,
            val id: Int,
            val number: Int,
            val title: String,
            val user: User,
            val labels: List<Label>,
            val state: String,
            val locked: Boolean,
            val assignee: User? = null,
            val milestone: Milestone? = null,
            val comments: Int,
            @SerializedName("created_at") val createdAt: String,
            @SerializedName("updated_at") val updatedAt: String,
            @SerializedName("closed_at") val closedAt: String? = null,
            val body: String? = null,
            @SerializedName("pull_request") val pullRequest: PullRequest.Simple? = null
        )

        data class Org(
            val id: Int,
            val login: String,
            @SerializedName("gravatar_id") val gravatarId: String,
            val url: String,
            @SerializedName("avatar_url") val avatarUrl: String
        )

        data class User(
            val login: String,
            val id: Int,
            @SerializedName("avatar_url") val avatarUrl: String,
            @SerializedName("gravatar_id") val gravatarId: String,
            val url: String,
            @SerializedName("html_url") val htmlUrl: String,
            @SerializedName("followers_url") val followersUrl: String,
            @SerializedName("following_url") val followingUrl: String,
            @SerializedName("gists_url") val gistsUrl: String,
            @SerializedName("starred_url") val starredUrl: String,
            @SerializedName("subscriptions_url") val subscriptionsUrl: String,
            @SerializedName("organizations_url") val organizationsUrl: String,
            @SerializedName("repos_url") val reposUrl: String,
            @SerializedName("events_url") val eventsUrl: String,
            @SerializedName("received_events_url") val receivedEventsUrl: String,
            val type: String,
            @SerializedName("site_admin") val siteAdmin: Boolean
        )

        sealed interface Repo {
            data class Simple(
                val id: Int,
                val name: String,
                val url: String
            )

            data class Full(
                val id: Int,
                val name: String,
                @SerializedName("full_name") val fullName: String? = null,
                val owner: User,
                val private: Boolean,
                @SerializedName("html_url") val htmlUrl: String,
                val description: String? = null,
                val fork: Boolean,
                val url: String,
                @SerializedName("forks_url") val forksUrl: String,
                @SerializedName("keys_url") val keysUrl: String,
                @SerializedName("collaborators_url") val collaboratorsUrl: String,
                @SerializedName("teams_url") val teamsUrl: String,
                @SerializedName("hooks_url") val hooksUrl: String,
                @SerializedName("issue_events_url") val issueEventsUrl: String,
                @SerializedName("events_url") val eventsUrl: String,
                @SerializedName("assignees_url") val assigneesUrl: String,
                @SerializedName("branches_url") val branchesUrl: String,
                @SerializedName("tags_url") val tagsUrl: String,
                @SerializedName("blobs_url") val blobsUrl: String,
                @SerializedName("git_tags_url") val gitTagsUrl: String,
                @SerializedName("git_refs_url") val gitRefsUrl: String,
                @SerializedName("trees_url") val treesUrl: String,
                @SerializedName("statuses_url") val statusesUrl: String,
                @SerializedName("languages_url") val languagesUrl: String,
                @SerializedName("stargazers_url") val stargazersUrl: String,
                @SerializedName("contributors_url") val contributorsUrl: String,
                @SerializedName("subscribers_url") val subscribersUrl: String,
                @SerializedName("subscription_url") val subscriptionUrl: String,
                @SerializedName("commits_url") val commitsUrl: String,
                @SerializedName("git_commits_url") val gitCommitsUrl: String,
                @SerializedName("comments_url") val commentsUrl: String,
                @SerializedName("issue_comment_url") val issueCommentUrl: String,
                @SerializedName("contents_url") val contentsUrl: String,
                @SerializedName("compare_url") val compareUrl: String,
                @SerializedName("merges_url") val mergesUrl: String,
                @SerializedName("archive_url") val archiveUrl: String,
                @SerializedName("downloads_url") val downloadsUrl: String,
                @SerializedName("issues_url") val issuesUrl: String,
                @SerializedName("pulls_url") val pullsUrl: String,
                @SerializedName("milestones_url") val milestonesUrl: String,
                @SerializedName("notifications_url") val notificationsUrl: String,
                @SerializedName("labels_url") val labelsUrl: String,
                @SerializedName("releases_url") val releasesUrl: String,
                @SerializedName("created_at") val createdAt: String,
                @SerializedName("updated_at") val updatedAt: String,
                @SerializedName("pushed_at") val pushedAt: String,
                @SerializedName("git_url") val gitUrl: String,
                @SerializedName("ssh_url") val sshUrl: String,
                @SerializedName("clone_url") val cloneUrl: String,
                @SerializedName("svn_url") val svnUrl: String,
                val homepage: String? = null,
                val size: Int,
                @SerializedName("stargazers_count") val stargazersCount: Int,
                @SerializedName("watchers_count") val watchersCount: Int,
                val language: String? = null,
                @SerializedName("has_issues") val hasIssues: Boolean,
                @SerializedName("has_downloads") val hasDownloads: Boolean,
                @SerializedName("has_wiki") val hasWiki: Boolean,
                @SerializedName("has_pages") val hasPages: Boolean,
                @SerializedName("forks_count") val forksCount: Int,
                @SerializedName("mirror_url") val mirrorUrl: String? = null,
                @SerializedName("open_issues_count") val openIssuesCount: Int,
                val forks: Int,
                @SerializedName("open_issues") val openIssues: Int,
                val watchers: Int,
                @SerializedName("default_branch") val defaultBranch: String,
                val public: Boolean? = null
            )
        }

        sealed interface PullRequest {
            data class Simple(
                val url: String,
                @SerializedName("html_url") val htmlUrl: String,
                @SerializedName("diff_url") val diffUrl: String,
                @SerializedName("patch_url") val patchUrl: String
            )

            data class Full(
                val url: String,
                val id: Int,
                @SerializedName("html_url") val htmlUrl: String,
                @SerializedName("diff_url") val diffUrl: String,
                @SerializedName("patch_url") val patchUrl: String,
                @SerializedName("issue_url") val issueUrl: String,
                val number: Int,
                val state: String,
                val locked: Boolean,
                val title: String,
                val user: User,
                val body: String? = null,
                @SerializedName("created_at") val createdAt: String,
                @SerializedName("updated_at") val updatedAt: String,
                @SerializedName("closed_at") val closedAt: String? = null,
                @SerializedName("merged_at") val mergedAt: String? = null,
                @SerializedName("merge_commit_sha") val mergeCommitSha: String? = null,
                val assignee: User? = null,
                val milestone: Milestone? = null,
                @SerializedName("commits_url") val commitsUrl: String,
                @SerializedName("review_comments_url") val reviewCommentsUrl: String,
                @SerializedName("review_comment_url") val reviewCommentUrl: String,
                @SerializedName("comments_url") val commentsUrl: String,
                @SerializedName("statuses_url") val statusesUrl: String,
                val head: Ref,
                val base: Ref,
                @SerializedName("_links") val links: Links,
                val merged: Boolean? = null,
                val mergeable: Boolean? = null,
                @SerializedName("mergeable_state") val mergeableState: String? = null,
                @SerializedName("merged_by") val mergedBy: User? = null,
                val comments: Int? = null,
                @SerializedName("review_comments") val reviewComments: Int? = null,
                val commits: Int? = null,
                val additions: Int? = null,
                val deletions: Int? = null,
                @SerializedName("changed_files") val changedFiles: Int? = null,
                val public: Boolean? = null
            ) {
                data class Ref(
                    val label: String,
                    val ref: String,
                    val sha: String,
                    val user: User,
                    val repo: Repo.Full? = null
                )
            }
        }

        data class Links(
            val self: Link,
            val html: Link,
            @SerializedName("pull_request") val pullRequest: Link? = null,
            val issue: Link? = null,
            val comments: Link? = null,
            @SerializedName("review_comments") val reviewComments: Link? = null,
            @SerializedName("review_comment") val reviewComment: Link? = null,
            val commits: Link? = null,
            val statuses: Link? = null
        ) {
            data class Link(
                val href: String
            )
        }

        data class Label(
            val url: String,
            val name: String,
            val color: String
        )

        data class Page(
            @SerializedName("page_name") val pageName: String,
            val title: String,
            val summary: String? = null,
            val action: String,
            val sha: String,
            @SerializedName("html_url") val htmlUrl: String
        )

        data class Comment(
            val url: String,
            @SerializedName("html_url") val htmlUrl: String,
            @SerializedName("pull_request_url") val pullRequestUrl: String? = null,
            @SerializedName("_links") val links: Links? = null,
            @SerializedName("issue_url") val issueUrl: String? = null,
            val id: Int,
            @SerializedName("diff_hunk") val diffHunk: String? = null,
            val path: String? = null,
            val position: Int? = null,
            val line: Int? = null,
            @SerializedName("original_position") val originalPosition: Int? = null,
            @SerializedName("commit_id") val commitId: String? = null,
            @SerializedName("original_commit_id") val originalCommitId: String? = null,
            val user: User,
            @SerializedName("created_at") val createdAt: String,
            @SerializedName("updated_at") val updatedAt: String,
            val body: String
        )

        data class Milestone(
            val url: String,
            @SerializedName("labels_url") val labelsUrl: String,
            val id: Int,
            val number: Int,
            val title: String,
            val description: String? = null,
            val creator: User,
            @SerializedName("open_issues") val openIssues: Int,
            @SerializedName("closed_issues") val closedIssues: Int,
            val state: String,
            @SerializedName("created_at") val createdAt: String,
            @SerializedName("updated_at") val updatedAt: String,
            @SerializedName("due_on") val dueOn: String? = null,
            @SerializedName("closed_at") val closedAt: String? = null
        )
    }

    data class Compact(
        val id: String,
        val type: String,
        val actor: Actor,
        val repo: Repo,
        val payload: Payload,
        val public: Boolean,
        @SerializedName("created_at") val createdAt: String
    ) {
        data class Actor(
            val id: Int,
            val login: String,
            @SerializedName("gravatar_id") val gravatarId: String,
            val url: String,
            @SerializedName("avatar_url") val avatarUrl: String
        )

        data class Repo(
            val id: Int,
            val name: String,
            val url: String
        )

        data class Payload(
            @SerializedName("push_id") val pushId: Int? = null,
            val size: Int? = null,
            @SerializedName("distinct_size") val distinctSize: Int? = null,
            val ref: String? = null,
            val head: String? = null,
            val before: String? = null,
            @SerializedName("ref_type") val refType: String? = null,
            @SerializedName("master_branch") val masterBranch: String? = null,
            val description: String? = null,
            @SerializedName("pusher_type") val pusherType: String? = null
        )
    }
}